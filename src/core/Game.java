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
        game.addVerb(new Break())
            .addVerb(new Choose())
            .addVerb(new Climb())
            .addVerb(new Close())
            .addVerb(new Credits())
            .addVerb(new Curse())
            .addVerb(new Diagnostic())
            .addVerb(new Drink())
            .addVerb(new Drop())
            .addVerb(new Eat())
            .addVerb(new Examine())
            .addVerb(new Give())
            .addVerb(new Hello())
            .addVerb(new Hit())
            .addVerb(new Inventory())
            .addVerb(new Light())
            .addVerb(new Listen())
            .addVerb(new Lock())
            .addVerb(new Look())
            .addVerb(new Make())
            .addVerb(new Move())
            .addVerb(new Open())
            .addVerb(new Poke())
            .addVerb(new Pray())
            .addVerb(new Put())
            .addVerb(new Quit())
            .addVerb(new Read())
            .addVerb(new Run())
            .addVerb(new Score())
            .addVerb(new Shout())
            .addVerb(new Sit())
            .addVerb(new Smell())
            .addVerb(new Stab())
            .addVerb(new Stand())
            .addVerb(new Suicide())
            .addVerb(new Take())
            .addVerb(new Talk())
            .addVerb(new Taste())
            .addVerb(new TurnOff())
            .addVerb(new TurnOn())
            .addVerb(new Unlock());

        //Add all Areas to the new world
        /*world.addArea("Test01",new Test01(world));
        world.addArea("Test02",new Test02(world));
        world.addArea("Test03",new Test03(world));
        world.addArea("Test04",new Test04(world));
        world.addArea("Test05",new Test05(world));
        world.addArea("Test06",new Test06(world));
        world.addArea("Test07",new Test07(world));
        world.addArea("Test08",new Test08(world));
        world.addArea("Test09",new Test09(world));
        world.addArea("Test10",new Test10(world));*/
        world.addArea("Hallway01", new Hallway01(world));
        world.addArea("Hallway02", new Hallway02(world));
        world.addArea("Hallway03", new Hallway03(world));
        world.addArea("Hallway04", new Hallway04(world));
        world.addArea("Hallway05", new Hallway05(world));
        world.addArea("Hallway06", new Hallway06(world));
        world.addArea("Hallway07", new Hallway07(world));
        world.addArea("Hallway08", new Hallway08(world));
        world.addArea("Hallway09", new Hallway09(world));
        world.addArea("Hallway10", new Hallway10(world));
        world.addArea("Hallway11", new Hallway11(world));
        world.addArea("Hallway12", new Hallway12(world));
        world.addArea("Hallway13", new Hallway13(world));
        world.addArea("Hallway14", new Hallway14(world));
        world.addArea("Hallway15", new Hallway15(world));
        world.addArea("Hallway16", new Hallway16(world));
        world.addArea("Hallway17", new Hallway17(world));
        world.addArea("AdamsonsRoom", new AdamsonsRoom(world));
        world.addArea("ArthursRoom", new ArthursRoom(world));
        world.addArea("BirkenfeldsRoom", new BirkenfeldsRoom(world));
        world.addArea("BoothsRoom", new BoothsRoom(world));
        world.addArea("BroadcastingRoom", new BroadcastingRoom(world));
        world.addArea("ChemicalStorageRoom", new ChemicalStorageRoom(world));
        world.addArea("CompSciRoom", new CompSciRoom(world));
        world.addArea("ConferenceRoom01", new ConferenceRoom01(world));
        world.addArea("ConferenceRoom02", new ConferenceRoom02(world));
        world.addArea("DuanesRoom", new DuanesRoom(world));
        world.addArea("FishersRoom", new FishersRoom(world));
        world.addArea("GharstsRoom", new GharstsRoom(world));
        world.addArea("HendrichsonsRoom", new HendrichsonsRoom(world));
        world.addArea("ISSRoom", new ISSRoom(world));
        world.addArea("JorstadsRoom", new JorstadsRoom(world));
        world.addArea("KUGRRoom", new KUGRRoom(world));
        world.addArea("KasslersRoom", new KasslersRoom(world));
        world.addArea("Library", new Library(world));
        world.addArea("MensRestroom", new MensRestroom(world));
        world.addArea("OishisRoom", new OishisRoom(world));
        world.addArea("RomarosRoom", new RomarosRoom(world));
        world.addArea("Roof", new Roof(world));
        world.addArea("RosenquistsRoom", new RosenquistsRoom(world));
        world.addArea("SchuchartsRoom", new SchuchartsRoom(world));
        world.addArea("SecretPassage", new SecretPassage(world));
        world.addArea("SecurityRoom", new SecurityRoom(world));
        world.addArea("StaffLounge", new StaffLounge(world));
        world.addArea("StakersRoom", new StakersRoom(world));
        world.addArea("WatchmansRoom", new WatchmansRoom(world));
        world.addArea("WilsonsRoom", new WilsonsRoom(world));
        world.addArea("WomensRestroom", new WomensRestroom(world));

        //Setting initial area for player
        player.setCurrentArea(world.getArea("CompSciRoom"));
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
                    command = Command.directedBare(new Move(), command.getDirection(), command.getLeftovers());
                }
                currentArea.interact(command, construct);
                System.out.println("");
            }
            player.getCurrentArea().interact(Command.bare(new Score(), ""), construct);
            System.out.println("");

        }
    }
    
    public Game addVerb(Verb verb) {
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
                } else if (matches.size() == 1) {
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
                    } else if (matches.size() == 1) {
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
