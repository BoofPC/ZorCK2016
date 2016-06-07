package core;

import java.util.ArrayList;
import java.util.Arrays;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        game.addVerb(new Break()).addVerb(new Choose()).addVerb(new Climb()).addVerb(new Close())
                .addVerb(new Credits()).addVerb(new Curse()).addVerb(new Diagnostic())
                .addVerb(new Drink()).addVerb(new Drop()).addVerb(new Eat()).addVerb(new Examine())
                .addVerb(new Give()).addVerb(new Hello()).addVerb(new Hit())
                .addVerb(new Inventory()).addVerb(new Light()).addVerb(new Listen())
                .addVerb(new Lock()).addVerb(new Look()).addVerb(new Make()).addVerb(new Move())
                .addVerb(new Open()).addVerb(new Poke()).addVerb(new Pray()).addVerb(new Put())
                .addVerb(new Quit()).addVerb(new Read()).addVerb(new Run()).addVerb(new Score())
                .addVerb(new Shout()).addVerb(new Sit()).addVerb(new Smell()).addVerb(new Stab())
                .addVerb(new Stand()).addVerb(new Suicide()).addVerb(new Take()).addVerb(new Talk())
                .addVerb(new Taste()).addVerb(new TurnOff()).addVerb(new TurnOn())
                .addVerb(new Unlock());

        //Add all Areas to the new world
        /*
        world.addArea(Test01.class)
            .addArea(Test02.class)
            .addArea(Test03.class)
            .addArea(Test04.class)
            .addArea(Test05.class)
            .addArea(Test06.class)
            .addArea(Test07.class)
            .addArea(Test08.class)
            .addArea(Test09.class)
            .addArea(Test10.class);
        */
        world.addArea(Hallway01.class).addArea(Hallway02.class).addArea(Hallway03.class)
                .addArea(Hallway04.class).addArea(Hallway05.class).addArea(Hallway06.class)
                .addArea(Hallway07.class).addArea(Hallway08.class).addArea(Hallway09.class)
                .addArea(Hallway10.class).addArea(Hallway11.class).addArea(Hallway12.class)
                .addArea(Hallway13.class).addArea(Hallway14.class).addArea(Hallway15.class)
                .addArea(Hallway16.class).addArea(Hallway17.class);
        world.addArea(AdamsonsRoom.class).addArea(ArthursRoom.class).addArea(BirkenfeldsRoom.class)
                .addArea(BoothsRoom.class).addArea(BroadcastingRoom.class)
                .addArea(ChemicalStorageRoom.class).addArea(CompSciRoom.class)
                .addArea(ConferenceRoom01.class).addArea(ConferenceRoom02.class)
                .addArea(DuanesRoom.class).addArea(FishersRoom.class).addArea(GharstsRoom.class)
                .addArea(HendrichsonsRoom.class).addArea(ISSRoom.class).addArea(JorstadsRoom.class)
                .addArea(KUGRRoom.class).addArea(KasslersRoom.class).addArea(Library.class)
                .addArea(MensRestroom.class).addArea(OishisRoom.class).addArea(RomarosRoom.class)
                .addArea(Roof.class).addArea(RosenquistsRoom.class).addArea(SchuchartsRoom.class)
                .addArea(SecretPassage.class).addArea(SecurityRoom.class).addArea(StaffLounge.class)
                .addArea(StakersRoom.class).addArea(WatchmansRoom.class).addArea(WilsonsRoom.class)
                .addArea(WomensRestroom.class);

        //Setting initial area for player
        player.setCurrentArea(world.getArea(CompSciRoom.class));
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
        player.getCurrentArea().enter(player);

        //Initial prompt setup
        try (Scanner reader = new Scanner(System.in)) {

            //Main Game Loop
            final Status status = Status.KEEP_PLAYING;
            while (status == Status.KEEP_PLAYING) {
                final Area currentArea = player.getCurrentArea();
                final String currentTitle = currentArea.title();
                if (currentArea.articleThe()) {
                    //...
                    System.out.println("You are in the " + currentTitle);
                } else {
                    System.out.println("You are in " + currentTitle);
                }

                System.out.print("> ");
                final String input = reader.nextLine();
                System.out.println("");

                Command command = Game.parse(input, construct, game.verbList);
                if (command.isBadParse()) {
                    System.out.println("What?");
                    continue;
                }
                if (command.isDirection()) {
                    command = Command.directedBare(new Move(), command.getDirection(),
                            command.getLeftovers());
                }
                currentArea.interact(command, construct);
                System.out.println("");
            }
            player.getCurrentArea().interact(Command.bare(new Score(), ""), construct);
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
        for (final Entry<String, Direction> entry : Game.directionShorthand.entrySet()) {
            final Pair<Direction, String> match =
                    Game.getMatch(input, entry.getValue(), entry.getKey());
            if (match != null)
                return Command.direction(match.getKey(), match.getValue());
        }
        verb: {
            final Verb verb;
            final String verbInput;
            {
                final Map<String, Pair<Verb, String>> matches = new HashMap<>();
                for (final Verb focus : verbList) {
                    Game.tryMatch(input, matches, focus, focus.getTitle());
                    for (final String syn : focus.getSynonyms()) {
                        Game.tryMatch(input, matches, focus, syn);
                    }
                }
                if (matches.isEmpty()) {
                    break verb;
                } else if (matches.size() > 1) {
                    Game.tryResolve(input, matches);
                }
                if (matches.size() == 1) {
                    final Pair<Verb, String> result =
                            matches.entrySet().iterator().next().getValue();
                    verb = result.getKey();
                    verbInput = result.getValue().trim();
                } else {
                    Game.ambiguous(matches.entrySet().stream().map(Entry::getKey).iterator());
                    break verb;
                }
            }
            final Usage usage = verb.getUsage();
            noun: if (usage.isNoun()) {
                final Item noun;
                final String nounInput;
                {
                    final Player player = construct.getPlayer();
                    final Map<String, Pair<Item, String>> matches = new HashMap<>();
                    for (final Item focus : player.getInventory()) {
                        for (final String syn : focus.synonyms()) {
                            Game.tryMatch(verbInput, matches, focus, syn);
                        }
                    }
                    for (final Item focus : player.getCurrentArea().items()) {
                        for (final String syn : focus.synonyms()) {
                            Game.tryMatch(verbInput, matches, focus, syn);
                        }
                    }

                    if (matches.isEmpty()) {
                        // System.out.println("No noun matches " + verbInput);
                        break noun;
                    } else if (matches.size() > 1) {
                        Game.tryResolve(verbInput, matches);
                    }
                    if (matches.size() == 1) {
                        final Pair<Item, String> result =
                                matches.entrySet().iterator().next().getValue();
                        noun = result.getKey();
                        nounInput = result.getValue().trim();
                    } else {
                        Game.ambiguous(matches.entrySet().stream().map(Entry::getKey).iterator());
                        break noun;
                    }
                }

                if (usage.isDirection()) {
                    for (final Entry<String, Direction> entry : Game.directionShorthand
                            .entrySet()) {
                        final Pair<Direction, String> match =
                                Game.getMatch(nounInput, entry.getValue(), entry.getKey());
                        if (match != null)
                            return Command.directed(verb, noun, match.getKey(), match.getValue());
                    }
                }

                return Command.applied(verb, noun, nounInput);
            }
            if (usage.isDirection()) {
                for (final Entry<String, Direction> entry : Game.directionShorthand.entrySet()) {
                    final Pair<Direction, String> match =
                            Game.getMatch(verbInput, entry.getValue(), entry.getKey());
                    if (match != null)
                        return Command.directedBare(verb, match.getKey(), match.getValue());
                }
            }
            if (!usage.isBare()) {
                // System.out.println(verb.getTitle() + " isn't bare. Leftovers: " + verbInput);
                break verb;
            }
            return Command.bare(verb, input);
        }
        return Command.badParse(input);
    }

    public static <T> void tryResolve(final String input, final Map<String, T> matches) {
        final Set<Entry<String, T>> matchSet = matches.entrySet();
        matchSet.stream().filter(e -> e.getKey().equals(input)).findFirst()
                .ifPresent(e -> matchSet.retainAll(Arrays.asList(e)));
    }

    private final static Matcher endOfMatch = Pattern.compile("^\\s").matcher("");

    public static <T> Pair<T, String> getMatch(final String input, final T focus,
            final String str) {
        if (input.startsWith(str)) {
            final String leftovers = input.substring(str.length());
            if (leftovers.isEmpty() || Game.endOfMatch.reset(leftovers).find())
                // System.out.println("Match: " + str + "; leftovers: " + leftovers);
                return new Pair<>(focus, leftovers);
        }
        return null;
    }

    public static <T> void tryMatch(final String input, final Map<String, Pair<T, String>> matches,
            final T focus, final String str) {
        final Pair<T, String> result = Game.getMatch(input, focus, str);
        if (result != null) {
            matches.put(str, result);
        }
    }

    public static void ambiguous(final Iterator<String> iterator) {
        System.out.print("Do you mean ");
        boolean hasNext = true;
        while (hasNext) {
            final String str = iterator.next();
            hasNext = iterator.hasNext();
            if (!hasNext) {
                System.out.print("or ");
            }
            System.out.print(str);
            if (hasNext) {
                System.out.print(", ");
            } else {
                System.out.println("?");
            }
        }
    }

    public static final Map<String, Direction> directionShorthand = Game.directionShorthand();

    private static Map<String, Direction> directionShorthand() {
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
}
