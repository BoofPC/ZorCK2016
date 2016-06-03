package core;

import java.util.ArrayList;
import verbs.*;
import areas.*;
import core.World.Direction;
import items.*;
import java.util.Arrays;
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
        final Context constr = new Context(player, world);
        Command com;

        //Fun printed start stuff
        System.out.println("Welcome to\n" + "d8888888P                    a88888b. dP     dP\n"
                + "     .d8'                   d8'   `88 88   .d8'\n"
                + "   .d8'   .d8888b. 88d888b. 88        88aaa8P' \n"
                + " .d8'     88'  `88 88'  `88 88        88   `8b.\n"
                + "d8'       88.  .88 88       Y8.   .88 88     88\n"
                + "Y8888888P `88888P' dP        Y88888P' dP     dP\n\n");

        //'enter' first room to get things started
        player.getCurrentArea().enter(player);

        //Initial prompt setup
        try (Scanner reader = new Scanner(System.in)) {
            String input = "";

            //Main Game Loop
            Status status = Status.KEEP_PLAYING;
            while (status == Status.KEEP_PLAYING) {
                if (player.getCurrentArea().getTitle().equals("Hallway")
                        || player.getCurrentArea().getTitle().equals("Women's Restroom")
                        || player.getCurrentArea().getTitle().equals("Men's Restroom")
                        || player.getCurrentArea().getTitle().equals("Security Room")
                        || player.getCurrentArea().getTitle().equals("Chemical Storage Room")) {
                    //...
                    System.out.println("You are in the " + player.getCurrentArea().getTitle());
                } else {
                    System.out.println("You are in " + player.getCurrentArea().getTitle());
                }

                System.out.print(">");
                input = reader.nextLine();
                System.out.println("");
                if (Game.findDirection(input) != null) {
                    player.getCurrentArea().interact(
                            new Command(new Move(), null, Game.findDirection(input)), constr);
                    //code to test parsers
                    /*else if(game.verbParser(input) != null){
                    System.out.println(game.verbParser(input).getTitle());
                    if(game.verbParser(input).getUsageKey(1)){
                        if(game.nounParser(input,player) != null){
                            if(!game.nounParser(input,player).getName().equals("noItem"))
                                System.out.println(game.nounParser(input,player).getName());
                            else if(!game.verbParser(input).getUsageKey(0))
                                System.out.println("Ya need a noun, ya dingus");
                        }else{
                            System.out.println("Where do you expect to find one of those?");
                        }
                    }
                    }*/
                } else if (game.verbParser(input) != null) {
                    //String verb = game.verbParser(input).getTitle();
                    final Verb verb = game.verbParser(input);
                    boolean conflict = false;
                    Item noun = null;
                    final List<Item> nouns = game.nounParser(input, player);
                    if (nouns != null) {
                        if (nouns.size() == 1) {
                            noun = nouns.get(0);
                        } else {
                            conflict = true;
                        }
                    }
                    if (!conflict) {
                        final Direction direction = game.directionParser(input);
                        com = new Command(verb, noun, direction);
                        player.getCurrentArea().interact(com, constr);



                        /*
                        }else if(verb.equals("quit")){
                            status = game.quit();
                        
                        }else if(verb.equals("suicide")){ status = game.suicide(player); }
                        */
                    } else {
                        if (nouns.size() > 3) {
                            System.out.print("Did you mean the ");
                            nouns.forEach(n -> System.out.println(n.name() + ", the "));
                            System.out.println(
                                    ", or the " + nouns.get(nouns.size() - 1).name() + "?");
                        } else {
                            System.out.print("Did you mean the " + nouns.get(0).name() + " or the "
                                    + nouns.get(1).name() + "?");
                        }
                    }
                    status = player.getDeath();
                }
                System.out.println("");
            }
            player.getCurrentArea().interact(new Command(new Score(), null, null), constr);
            System.out.println("");
        }
    }


    public Verb findVerb(final String input) {
        return this.verbList.stream().filter(i -> i.hasMatching(input)).findAny().orElse(null);
    }

    public List<Item> findNoun(final String input, final Player player) {
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

    public Verb verbParser(final String input) {
        return Arrays.stream(input.toLowerCase().split("\\s+")).map(this::findVerb)
                .filter(i -> i != null).findFirst().orElse(null);
    }

    public List<Item> nounParser(final String input, final Player player) {
        return Arrays.stream(input.toLowerCase().split("\\s+")).map(i -> {
            final Item pItem = player.getItem(i);
            if (pItem != null)
                return pItem;
            return player.getCurrentArea().getItem(i);
        }).filter(i -> i != null).collect(Collectors.toCollection(ArrayList::new));
    }

    public Direction directionParser(String input) {
        return Arrays.stream(input.toLowerCase().split("\\s+")).map(Game::findDirection)
                .filter(i -> i != null).findFirst().orElse(null);
    }

    public int quit() {
        System.out.println("Goodbye!");
        return 1;
    }
}
