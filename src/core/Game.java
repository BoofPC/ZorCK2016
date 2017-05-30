package core;

import java.util.ArrayList;

import verbs.*;
import areas.*;
import core.Verb.Usage;
import core.World.Direction;
import items.*;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Game {
    public static enum Status {
        KEEP_PLAYING, SELF_QUIT, WIN, DIE, SUICIDE
    }

    private final List<Verb> verbList = new ArrayList<Verb>();

    public static void main(final String[] args) {
        final Game game = new Game();
        final Player player = new Player(10, "Carlton");
        final World world = new World();

        // Register all verbs
        game.addVerb(new Bless()).addVerb(new Close()).addVerb(new Credits()).addVerb(new Curse()).addVerb(new Debug())
                .addVerb(new Diagnostic()).addVerb(new Drop()).addVerb(new Eat()).addVerb(new Examine())
                .addVerb(new Give()).addVerb(new Hello()).addVerb(new Hit()).addVerb(new Inventory())
                .addVerb(new Lock()).addVerb(new Look()).addVerb(new Move()).addVerb(new Open())
                .addVerb(new Poke()).addVerb(new Put()).addVerb(new Quit()).addVerb(new Read())
                .addVerb(new Score()).addVerb(new Shout()).addVerb(new Smell()).addVerb(new Stab())
                .addVerb(new Stand()).addVerb(new Suicide()).addVerb(new Take()).addVerb(new Talk())
                .addVerb(new Throw()).addVerb(new TurnOff()).addVerb(new TurnOn()).addVerb(new Unlock())
                .addVerb(new Use());


        //Add all Areas to the new world
        world.addArea(CenterRoom.class).addArea(EastRoom.class).addArea(NorthRoom.class);

        //Setting initial area for player
        player.setCurrentArea(world.getArea(CenterRoom.class));
        player.addItem(new NoTea());
        final Context construct = new Context(player, world);

        //Fun printed start stuff @formatter:off
        System.out.println("Welcome to\n"
                + "d8888888P                    a88888b. dP     dP\n"
                + "     .d8'                   d8'   `88 88   .d8'\n"
                + "   .d8'   .d8888b. 88d888b. 88        88aaa8P' \n"
                + " .d8'     88'  `88 88'  `88 88        88   `8b.\n"
                + "d8'       88.  .88 88       Y8.   .88 88     88\n"
                + "Y8888888P `88888P' dP        Y88888P' dP     dP\n\n");
        //@formatter:on

        //'enter' first room to get things started
        //player.getCurrentArea().enter(player);

        //Initial prompt setup
        try (Scanner reader = new Scanner(System.in)) {
            //Main Game Loop
            Status death = null;
            while ((death = player.getDeath()) == Status.KEEP_PLAYING) {
                final Area<?> currentArea = player.getCurrentArea();
                final String currentTitle = currentArea.title();
                if (currentArea.articleThe()) {
                    System.out.println("You are in the " + currentTitle);
                } else {
                    System.out.println("You are in " + currentTitle);
                }

                System.out.print("> ");
                final String input = reader.nextLine();

                Command command = Game.parse(input, construct, game.verbList);
                if (command.isBadParse()) {
                    System.out.println("What?");
                    continue;
                }
                if (command.isDirection()) {
                    command = Command.directedBare(new Move(), "move", command.getDirection(),
                            command.getDirectionStr(), command.getLeftovers());
                }
                currentArea.interact(command, construct);
                System.out.println("");
            }

            switch (death) {
                case DIE:
                    System.out.println("You have died.");
                    break;
                case SUICIDE:
                    System.out.println("You decided to end it all.");
                    break;
                case SELF_QUIT:
                    System.out.println("See you again soon!");
                    break;
                case WIN:
                    System.out.println("A winnner is you!");
                    break;
                default:
            }
            player.getCurrentArea().interact(Command.bare(new Score(), "score", ""), construct);
            System.out.println("");
        }
    }

    public Game addVerb(final Verb verb) {
        this.verbList.add(verb);
        return this;
    }

    public static Command parse(final String inputRaw, final Context construct,
            final List<Verb> verbList) {
        final String input = inputRaw.trim().toLowerCase();
        for (final Entry<String, Direction> entry : Game.dirShorthand.entrySet()) {//checking for cardinal directions
            final Pair<Direction, Pair<String, String>> match =
                    Game.getMatch(input, entry.getValue(), entry.getKey(), null);
            if (match != null) {
                final Pair<String, String> matchStrs = match.getValue();
                return Command.direction(match.getKey(), matchStrs.getKey(), matchStrs.getKey());//return direction
            }
        }
        verb: {
            final Verb verb;
            final String verbStr;
            final String verbInput;
            {
                final Map<String, Pair<Verb, Pair<String, String>>> matches = new HashMap<>();
                for (final Verb focus : verbList) {
                    // System.out.println("trying " + focus.getTitle());
                    if (focus.getUsage().isArbitrary() && inputRaw.startsWith(focus.getTitle())) {
                        return Command.bare(focus, focus.getTitle(), inputRaw);//returning arbitrary verb
                    }
                    Game.tryMatch(matches, input, focus, focus.getTitle(), focus.getUsage());
                    for (final String syn : focus.getSynonyms()) {
                        Game.tryMatch(matches, input, focus, syn, focus.getUsage());//fill matches with possible verb matches
                    }
                }
                if (matches.isEmpty()) {
                    break verb;//no possible matches
                } else if (matches.size() > 1) {
                    Game.disambiguate(input, matches);
                }
                if (matches.size() == 1) {
                    final Pair<Verb, Pair<String, String>> result =
                            matches.entrySet().iterator().next().getValue();
                    verb = result.getKey();
                    final Pair<String, String> verbStrs = result.getValue();
                    verbStr = verbStrs.getKey();
                    verbInput = verbStrs.getValue().trim();
                } else {//more than one possible match, request to clarify
                    Game.ambiguous(matches.entrySet().stream()
                            .map(e -> new Pair<>(e.getValue().getKey(), e.getKey())).iterator(),
                            Verb::getTitle);
                    break verb;
                }
            }//at this point, one possible verb
            final Usage usage = verb.getUsage();
            noun: if (usage.isNoun()) {
                final Item noun;
                final Command.NounOrigin nounOrigin;
                final String nounStr;
                final String nounInput;
                {//looking for what noun is referencing
                    final Player player = construct.getPlayer();
                    final Map<String, Pair<Pair<Item, Command.NounOrigin>, Pair<String, String>>> matches =
                            new HashMap<>();
                    for (final Item focus : player.getInventory()) {
                        for (final String syn : focus.synonyms()) {
                            // System.out.println("trying " + syn);
                            Game.tryMatch(matches, verbInput,
                                    new Pair<>(focus, Command.NounOrigin.PLAYER), syn, null);
                        }
                    }
                    for (final Item focus : player.getCurrentArea().items()) {
                        for (final String syn : focus.synonyms()) {
                            // System.out.println("trying " + syn);
                            Game.tryMatch(matches, verbInput,
                                    new Pair<>(focus, Command.NounOrigin.AREA), syn, null);
                        }
                    }

                    if (matches.isEmpty()) {
                        // System.out.println("No noun matches " + verbInput);
                        break noun;
                    } else if (matches.size() > 1) {
                        Game.disambiguate(verbInput, matches);
                    }
                    if (matches.size() == 1) {
                        final Pair<Pair<Item, Command.NounOrigin>, Pair<String, String>> result =
                                matches.entrySet().iterator().next().getValue();
                        final Pair<Item, Command.NounOrigin> noun_ = result.getKey();
                        noun = noun_.getKey();
                        nounOrigin = noun_.getValue();
                        final Pair<String, String> nounStrs = result.getValue();
                        nounStr = nounStrs.getKey();
                        nounInput = nounStrs.getValue().trim();
                    } else {
                        Game.ambiguous(matches.entrySet().stream()
                                .map(e -> new Pair<>(e.getValue().getKey().getKey(), e.getKey()))
                                .iterator(), Item::name);
                        break noun;
                    }
                }

                if (usage.isDirection()) {
                    for (final Entry<String, Direction> entry : Game.dirShorthand.entrySet()) {
                        final Pair<Direction, Pair<String, String>> match =
                                Game.getMatch(nounInput, entry.getValue(), entry.getKey(), null);
                        if (match != null) {
                            final Pair<String, String> directionStrs = match.getValue();
                            return Command.directed(verb, verbStr, noun, nounStr, nounOrigin,
                                    match.getKey(), directionStrs.getKey(),
                                    directionStrs.getValue());
                        }
                    }
                }
                //ends noun block
                return Command.applied(verb, verbStr, noun, nounStr, nounOrigin, nounInput);
            }
            if (usage.isDirection()) {
                for (final Entry<String, Direction> entry : Game.dirShorthand.entrySet()) {
                    final Pair<Direction, Pair<String, String>> match =
                            Game.getMatch(verbInput, entry.getValue(), entry.getKey(), null);
                    if (match != null) {
                        final Pair<String, String> directionStrs = match.getValue();
                        return Command.directedBare(verb, verbStr, match.getKey(),
                                directionStrs.getKey(), directionStrs.getValue());
                    }
                }
            }
            if (!usage.isBare()) {
                // System.out.println(verb.getTitle() + " isn't bare. Leftovers: " + verbInput);
                break verb;
            }
            return Command.bare(verb, verbStr, input);
        }
        return Command.badParse(input);
    }

    public static <A, B> void disambiguate(final String input,
            final Map<String, Pair<A, B>> matches) {
        final Set<Entry<String, Pair<A, B>>> matchSet = matches.entrySet();
        matchSet.retainAll(
                matchSet.stream().sorted((a, b) -> b.getKey().length() - a.getKey().length())
                        .filter(Game.distinctByKey(e -> e.getValue().getKey()))
                        .collect(Collectors.toList()));
    }

    private final static Matcher endOfMatch = Pattern.compile("^\\s").matcher("");

    public static <T> Pair<T, Pair<String, String>> getMatch(final String input, final T focus,
            final String str, final Verb.Usage vUsage) {
        if (input.startsWith(str)) {
            final String leftovers = input.substring(str.length());
            final boolean verb = vUsage != null; //focus instanceof Verb;
            //final Verb.Usage vUse = verb ? ((Verb) focus).getUsage() : null;
            final boolean vBare = verb ? vUsage.isBare() : true;
            final boolean vMore = verb ? vUsage.isNoun() || vUsage.isDirection() : true;
            if ((leftovers.isEmpty() && vBare)
                    || (Game.endOfMatch.reset(leftovers).find() && vMore)) {
                // System.out.println("Match:" + str + ";leftovers:" + leftovers + ";");
                return new Pair<>(focus, new Pair<>(str, leftovers));
            }
        }
        return null;
    }

    public static <T> void tryMatch(final Map<String, Pair<T, Pair<String, String>>> matches,
            final String input, final T focus, final String str, final Verb.Usage vUsage) {
        final Pair<T, Pair<String, String>> result = Game.getMatch(input, focus, str, vUsage);
        if (result != null) {
            matches.put(str, result);
        }
    }

    public static <T> void ambiguous(final Iterator<Pair<T, String>> iterator,
            final Function<T, String> normalName) {
        System.out.print("Do you mean ");
        boolean hasNext = true;
        while (hasNext) {
            final Pair<T, String> strs = iterator.next();
            hasNext = iterator.hasNext();
            if (!hasNext) {
                System.out.print("or ");
            }
            System.out.print(normalName.apply(strs.getKey()));
            System.out.print(" (");
            System.out.print(strs.getValue());
            System.out.print(')');
            if (hasNext) {
                System.out.print(", ");
            } else {
                System.out.println("?");
            }
        }
    }

    public static final Map<String, Direction> dirShorthand = Game.dirShorthand();

    private static Map<String, Direction> dirShorthand() {
        final Map<String, Direction> map = new HashMap<>();
        map.put("north", Direction.NORTH);
        map.put("n", Direction.NORTH);
        map.put("east", Direction.EAST);
        map.put("e", Direction.EAST);
        map.put("south", Direction.SOUTH);
        map.put("s", Direction.SOUTH);
        map.put("west", Direction.WEST);
        map.put("w", Direction.WEST);
        map.put("northeast", Direction.NORTHEAST);
        map.put("ne", Direction.NORTHEAST);
        map.put("southeast", Direction.SOUTHEAST);
        map.put("se", Direction.SOUTHEAST);
        map.put("southwest", Direction.SOUTHWEST);
        map.put("sw", Direction.SOUTHWEST);
        map.put("northwest", Direction.NORTHWEST);
        map.put("nw", Direction.NORTHWEST);
        map.put("up", Direction.UP);
        map.put("u", Direction.UP);
        map.put("down", Direction.DOWN);
        map.put("d", Direction.DOWN);
        return map;
    }

    public static <T> Predicate<T> distinctByKey(final Function<? super T, Object> keyExtractor) {
        final Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> {
            //System.out.println("Testing " + t.toString());
            return seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
        };
    }
}
