package core;

import java.util.ArrayList;
import verbs.*;
import areas.*;
import core.World.Direction;
import items.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Command com;

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
            String rawInput = "";

            //Main Game Loop
            Status status = Status.KEEP_PLAYING;
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
                rawInput = reader.nextLine();
                System.out.println("");

                final List<String> inputs =
                        new ArrayList<>(Arrays.asList(rawInput.toLowerCase().split("\\s+")));
                final List<List<String>> inputsPower = Game.powerset(inputs);
                final List<String> inputsConcat = inputsPower.stream()
                        .map(l -> l.stream().map(StringBuilder::new).reduce(new StringBuilder(),
                                (a, b) -> a.append(" ").append(b)))
                        .map(StringBuilder::toString)
                        .collect(Collectors.toCollection(ArrayList::new));

                final Direction findDirection = Game.findDirection(rawInput);
                parsing: {
                    if (findDirection != null) {
                        currentArea.interact(new Command(new Move(), null, findDirection),
                                construct);
                        break parsing;
                    }
                    //code to test parsers
                    final Verb verb = Game.verbParser(inputsConcat, game.verbList);
                    /* Parser test
                    if (verb != null) {
                        System.out.println(verb.getTitle());
                        if (verb.getUsage().isNoun()) {
                            final List<Item> nouns = Game.nounParser(inputsConcat, player);
                            if (nouns != null) {
                                if (!nouns.get(0).name().equals("noItem")) {
                                    System.out.println(nouns.get(0).name());
                                } else {
                                    if (!verb.getUsage().isBare()) {
                                        System.out.println("Ya need a noun, ya dingus");
                                    }
                                }
                            } else {
                                System.out.println("Where do you expect to find one of those?");
                            }
                        }
                        break parsing;
                    }
                    */
                    if (verb != null) {
                        boolean conflict = false;
                        Item noun = null;
                        final List<Item> nouns = Game.nounParser(inputsConcat, player);
                        if (nouns != null) {
                            if (nouns.size() == 1) {
                                noun = nouns.get(0);
                            } else {
                                conflict = true;
                            }
                        }
                        if (!conflict) {
                            final Direction direction = Game.directionParser(inputsConcat);
                            com = new Command(verb, noun, direction);
                            currentArea.interact(com, construct);
                        } else {
                            if (nouns.size() > 3) {
                                System.out.print("Did you mean the ");
                                final int limit = nouns.size() - 1;
                                for (int i = 0; i < limit; i++) {
                                    System.out.println(nouns.get(i).name() + ", the ");
                                }
                                System.out.println(", or the " + nouns.get(limit).name() + "?");
                            } else {
                                System.out.print("Did you mean the " + nouns.get(0).name()
                                        + " or the " + nouns.get(1).name() + "?");
                            }
                        }
                        status = player.getDeath();
                        break parsing;
                    }
                }
                System.out.println("");
            }
            player.getCurrentArea().interact(new Command(new Score(), null, null), construct);
            System.out.println("");
        }
    }

    public static Verb findVerb(final String input, final List<Verb> verbList) {
        return verbList.stream().filter(i -> i.hasMatching(input)).findAny().orElse(null);
    }

    public static List<Item> findNoun(final String input, final Player player) {
        return Stream
                .concat(player.getInventory().stream(), player.getCurrentArea().getItems().stream())
                .filter(item -> item.hasMatching(input))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Direction findDirection(final String input) {
        switch (input) {
            case "north":
            case "n":
                return Direction.NORTH;
            case "east":
            case "e":
                return Direction.EAST;
            case "south":
            case "s":
                return Direction.SOUTH;
            case "west":
            case "w":
                return Direction.WEST;
            case "northeast":
            case "ne":
                return Direction.NORTHEAST;
            case "southeast":
            case "se":
                return Direction.SOUTHEAST;
            case "southwest":
            case "sw":
                return Direction.SOUTHWEST;
            case "northwest":
            case "nw":
                return Direction.NORTHWEST;
            case "up":
            case "u":
                return Direction.UP;
            case "down":
            case "d":
                return Direction.DOWN;
            default:
                return null;
        }
    }

    public static Verb verbParser(final List<String> input, final List<Verb> verbList) {
        return input.stream().map(v -> Game.findVerb(v, verbList)).filter(i -> i != null)
                .findFirst().orElse(null);
    }

    public static List<Item> nounParser(final List<String> inputs, final Player player) {
        final List<Item> output = inputs.stream().map(i -> {
            final Item pItem = player.getItem(i);
            if (pItem != null)
                return pItem;
            return player.getCurrentArea().getItem(i);
        }).filter(i -> i != null).collect(Collectors.toCollection(ArrayList::new));
        if (output.isEmpty()) {
            output.add(new NoItem());
        }
        return output;
    }

    public static Direction directionParser(final List<String> input) {
        return input.stream().map(Game::findDirection).filter(i -> i != null).findFirst()
                .orElse(null);
    }

    public static int quit() {
        System.out.println("Goodbye!");
        return 1;
    }

    // From http://rosettacode.org/wiki/Power_Set ; under GNU FDL 1.2
    public static <T> List<List<T>> powerset(final Collection<T> list) {
        List<List<T>> ps = new ArrayList<List<T>>();
        ps.add(new ArrayList<T>()); // add the empty set

        // for every item in the original list
        for (final T item : list) {
            final List<List<T>> newPs = new ArrayList<List<T>>();

            for (final List<T> subset : ps) {
                // copy all of the current powerset's subsets
                newPs.add(subset);

                // plus the subsets appended with the current item
                final List<T> newSubset = new ArrayList<T>(subset);
                newSubset.add(item);
                newPs.add(newSubset);
            }

            // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
            ps = newPs;
        }
        return ps;
    }
}
