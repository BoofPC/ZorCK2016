package core;

import java.util.ArrayList;
import verbs.*;
import areas.*;
import core.World.Direction;
import items.*;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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
        game.verbList.add(new Break());
        game.verbList.add(new Choose());
        game.verbList.add(new Climb());
        game.verbList.add(new Close());
        game.verbList.add(new Credits());
        game.verbList.add(new Curse());
        game.verbList.add(new Diagnostic());
        game.verbList.add(new Drink());
        game.verbList.add(new Drop());
        game.verbList.add(new Eat());
        game.verbList.add(new Examine());
        game.verbList.add(new Give());
        game.verbList.add(new Hello());
        game.verbList.add(new Hit());
        game.verbList.add(new Inventory());
        game.verbList.add(new Light());
        game.verbList.add(new Listen());
        game.verbList.add(new Lock());
        game.verbList.add(new Look());
        game.verbList.add(new Make());
        game.verbList.add(new Move());
        game.verbList.add(new Open());
        game.verbList.add(new Poke());
        game.verbList.add(new Pray());
        game.verbList.add(new Put());
        game.verbList.add(new Quit());
        game.verbList.add(new Read());
        game.verbList.add(new Run());
        game.verbList.add(new Score());
        game.verbList.add(new Shout());
        game.verbList.add(new Sit());
        game.verbList.add(new Smell());
        game.verbList.add(new Stab());
        game.verbList.add(new Stand());
        game.verbList.add(new Suicide());
        game.verbList.add(new Take());
        game.verbList.add(new Talk());
        game.verbList.add(new Taste());
        game.verbList.add(new TurnOff());
        game.verbList.add(new TurnOn());
        game.verbList.add(new Unlock());

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
        world.addArea("CompSciRoom", new CompSciRoom(world));
        world.addArea("FishersRoom", new FishersRoom(world));
        world.addArea("HendrichsonsRoom", new HendrichsonsRoom(world));
        world.addArea("Roof", new Roof(world));
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
                final String currentTitle = currentArea.getTitle();
                if (currentTitle.equals("Hallway") || currentTitle.equals("Women's Restroom")
                        || currentTitle.equals("Men's Restroom")
                        || currentTitle.equals("Security Room")
                        || currentTitle.equals("Chemical Storage Room")) {
                    //...
                    System.out.println("You are in the " + currentTitle);
                } else {
                    System.out.println("You are in " + currentTitle);
                }

                System.out.print(">");
                final String input = reader.nextLine();
                System.out.println("");

                final Command command = Game.parse(input, construct, game.verbList);
                if (command.isBadParse()) {
                    System.out.println("What?");
                    continue;
                }
                currentArea.interact(command, construct);
                System.out.println("");
            }
            player.getCurrentArea().interact(Command.bare(new Score(), ""), construct);
            System.out.println("");

        }
    }

    public static Command parse(final String inputRaw, final Context construct,
            final List<Verb> verbList) {
        String input = inputRaw.trim().toLowerCase();
        for (final Entry<String, Direction> entry : Game.directionShorthand.entrySet()) {
            if (input.equals(entry.getKey()))
                return Command.direction(entry.getValue(), null);
        }
        verb: {
            final Verb verb;
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
                    input = result.getValue().trim();
                } else {
                    Game.ambiguous(matches.entrySet().stream().map(Entry::getKey).iterator());
                    break verb;
                }
            }
            noun: {
                final Item noun;
                {
                    final Player player = construct.getPlayer();
                    final Map<String, Pair<Item, String>> matches = new HashMap<>();
                    for (final Item focus : player.getInventory()) {
                        for (final String syn : focus.synonyms()) {
                            Game.tryMatch(input, matches, focus, syn);
                        }
                    }
                    for (final Item focus : player.getCurrentArea().getItems()) {
                        for (final String syn : focus.synonyms()) {
                            Game.tryMatch(input, matches, focus, syn);
                        }
                    }

                    if (matches.isEmpty()) {
                        break noun;
                    } else if (matches.size() == 1) {
                        final Pair<Item, String> result =
                                matches.entrySet().iterator().next().getValue();
                        noun = result.getKey();
                        input = result.getValue().trim();
                    } else {
                        Game.ambiguous(matches.entrySet().stream().map(Entry::getKey).iterator());
                        break noun;
                    }
                }
                return Command.applied(verb, noun, input);
            }
            return Command.bare(verb, input);
        }
        return Command.badParse(input);
    }

    public static <T> void tryMatch(final String input, final Map<String, Pair<T, String>> matches,
            final T focus, final String syn) {
        if (input.startsWith(syn)) {
            matches.put(syn, new Pair<>(focus, input.substring(syn.length())));
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
                System.out.print("?");
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
