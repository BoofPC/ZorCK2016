package verbs;

import java.util.ArrayList;
import java.util.Random;

import core.Area;
import core.Command;
import core.Context;
import core.Game;
import core.Item;
import core.Player;
import core.Verb;
import core.World;
import items.DuckOfDoom;
import items.Sword;

public final class Verbs {
    private Verbs() {}

    public static class Bless extends Verb {
        public Bless() {
            super("bless",
                    new String[] {"God bless", "b l e s s", "55318", "BLESS", "B L E S S",
                            "8 1 3 5 5", "81355", "81ESS", "81E55", "bless"},
                    new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();
            Random rand = new Random();

            int n = rand.nextInt(10);
            if (n == 0) {
                System.out.println("You dont know why but you feel better");
            } else if (n == 1 || n == 5) {
                System.out.println("Nothing happens . . .");
            } else if (n == 2 || n == 4) {
                System.out.println("A duck appered. You feel compelled to pick it up."
                        + "you look right into it's beady red eyes");
                player.addItem(new DuckOfDoom());
            } else if (n == 3 || n == 6) {
                System.out.println("You hear the dark chuckling of evil overlord Booth");
            } else if (n == 3 || n == 6) {
                System.out.println("Good idea blessing is super effective");
            } else if (n == 7 || n == 8) {
                System.out.println("May your goats grow and prosper.");
            } else {
                System.out.println("You hear a very powerful sneeze");
            }
        }
    }

    public static class Break extends Verb {
        public Break() {
            super("break", new String[] {"shatter", "destroy"}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(15) == 2) {
                        // TODO: find a better way to destroy something
                        noun.setUsageKey(0, 2);
                        noun.setUsageKey(15, 3);
                        System.out.println("You broke the " + noun.getName());
                    } else if (noun.getUsageKey(0) == 3) {
                        System.out.println("The " + noun.getName() + " is already broken.");
                    } else {
                        System.out.println("You can't break the " + noun.getName());
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus.");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Buy extends Verb {
        public Buy() {
            super("buy", new String[] {"purchase"}, new boolean[] {false, true, false});
        }
    }

    public static class Choose extends Verb {
        public Choose() {
            super("choose", new String[] {"select"}, new boolean[] {false, true, true});
        }
    }

    public static class Climb extends Verb {
        public Climb() {
            super("climb", new String[] {"scale"}, new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(13) == 2 && player.getCurrentArea().getPortal(8) != null) {
                        if (!player.getCurrentArea().getPortal(8).isLocked()) {
                            construct.getPlayer().getCurrentArea()
                                    .interact(new Command(new Move(), null, 8), construct);
                        } else {
                            System.out.println("You can't climb that!");
                        }
                    } else {
                        System.out.println("You can't climb that!");
                    }
                } else {
                    construct.getPlayer().getCurrentArea()
                            .interact(new Command(new Move(), null, 8), construct);
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Close extends Verb {
        public Close() {
            super("close", new String[] {"shut"}, new boolean[] {false, true, false});

        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(4) == 3) {
                        noun.setUsageKey(4, 2);
                        System.out.println("You closed the " + noun.getName());
                    } else if (noun.getUsageKey(4) == 2) {
                        System.out.println(noun.getName() + " is already closed");
                    } else {
                        System.out.println("I don't see how you expect to do that");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Curse extends Verb {
        public Curse() {
            super("damn",
                    new String[] {"anal", "anus", "arse", "ass", "asshole", "ballsack", "balls",
                            "bastard", "bitch", "blowjob", "blow job", "boner", "boob", "bum",
                            "butt", "buttplug", "clitoris", "cock", "cocksucker", "coon", "crap",
                            "cunt", "dick", "dildo", "dyke", "fag", "fellate", "fellatio",
                            "feltcher", "fuck", "f u c k", "fudgepacker", "fudge packer", "goddamn",
                            "god damn", "hell", "homo", "jizz", "labia", "motherfucker", "muff",
                            "nigger", "nigga", "penis", "piss", "poop", "prick", "pube", "pussy",
                            "queef", "queer", "scrotum", "sex", "shit", "slut", "smegma", "spunk",
                            "tit", "tosser", "twat", "vagina", "wank", "whore"},
                    new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            Random rand = new Random();
            int n = rand.nextInt(4);
            if (n == 0) {
                System.out.println("Tough shit, asshole");
            } else if (n == 1) {
                System.out.println("Its not so bad.  You could have " + "been killed already.");
            } else if (n == 2) {
                System.out.println(
                        "Oh, dear. Such language from a " + "supposed winning adventurer!");
            } else {
                System.out.println("Such language in a high-class establishment like this!");
            }
        }
    }

    public static class Diagnostic extends Verb {
        public Diagnostic() {
            super("diagnostic", new String[] {"status", "health"},
                    new boolean[] {true, false, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();

            System.out.println("\tHealth: " + player.getHp() + " / " + player.getMaxHp());
        }
    }

    public static class Drink extends Verb {
        public Drink() {
            super("drink", new String[] {"sip", "quaff"}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    switch (noun.getUsageKey(3)) {
                        case 2:
                            noun.setUsageKey(3, 4);
                            System.out.println("You drank the " + noun.getName());
                            break;
                        case 3:
                            System.out.println("You need to open it first!");
                            break;
                        case 4:
                            System.out.println("You already drank that!");
                            break;
                        default:
                            System.out.println("You can't drink that!");
                            break;
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Drop extends Verb {
        public Drop() {
            super("drop", new String[] {"release", "throw out", "toss", "leave"},
                    new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();

            if (player.hasMatching(noun)) {
                if (noun.getUsageKey(1) == 1) {
                    player.removeItem(noun);
                    player.getCurrentArea().addItem(noun);
                    System.out.println("You dropped " + noun.getName());
                } else {
                    System.out.println(
                            "I'm sorry " + player.getName() + ", I can't allow you to do that");
                }
            } else {
                System.out.println("You don't have the " + noun.getName());
            }
        }
    }

    public static class Eat extends Verb {
        public Eat() {
            super("eat", new String[] {"consume", "devour", "ingest"},
                    new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();

            if (noun.getUsageKey(2) == 2) {
                if (player.getCurrentArea().hasMatching(noun)) {
                    player.getCurrentArea().removeItem(noun);
                } else if (player.hasMatching(noun)) {
                    player.removeItem(noun);
                }
                System.out.println(player.getName() + " ate the " + noun.getName());
                if (noun.getTaste() != null) {
                    System.out.println(noun.getTaste());
                } else {
                    System.out.println(
                            "It tastes like every other " + noun.getName() + " you've ever eaten");
                }
            } else {
                System.out.println("I don't see how you expect to do that!");
            }
        }
    }

    public static class Examine extends Verb {
        public Examine() {
            super("examine", new String[] {"look at", "scan", "study", "observe"},
                    new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getDescription() != null) {
                        System.out.println(noun.getDescription());
                    } else {
                        System.out.println("It looks like every other " + noun.getName()
                                + " you've ever seen");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Give extends Verb {
        public Give() {
            super("give", new String[] {"gift"}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();

            if (player.hasMatching(noun)) {
                Item receiver;
                receiver = null;
                for (int i = 0; i < player.getCurrentArea().listItems().length; i++) {
                    if (player.getCurrentArea().listItems()[i].getUsageKey(14) == 2) {
                        receiver = player.getCurrentArea().listItems()[i];
                        break;
                    }
                }
                if (receiver != null) {
                    receiver.receive(noun);
                    player.removeItem(noun);
                    System.out.println(
                            "You gave the " + noun.getName() + " to " + receiver.getName());
                } else {
                    System.out.println("I don't see who you'd want to give that to");
                }
            } else {
                System.out.println("You don't even have a " + noun.getName());
            }
        }
    }

    public static class Hello extends Verb {
        public Hello() {
            super("hello", new String[] {"hi", "good day", "good morning", "good afternoon",
                    "good evening"}, new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            int n = new Random().nextInt(10);
            switch (n) {
                case 0:
                    System.out.println("Good day");
                    break;
                case 1:
                    System.out.println("Hey, there");
                    break;
                case 2:
                    System.out.println("Greetings");
                    break;
                case 3:
                    System.out.println("Hi");
                    break;
                case 4:
                    System.out.println("You have something in your teeth");
                    break;
                case 5:
                    System.out.println("What's up?");
                    break;
                case 6:
                    System.out.println("Hello, " + construct.getPlayer().getName());
                    break;
                case 7:
                    System.out.println("Nice weather we're having");
                    break;
                case 8:
                    System.out.println("Howdy");
                    break;
                default:
                    System.out.println("Hello");
                    break;
            }
        }
    }

    public static class Hit extends Verb {
        public Hit() {
            super("hit", new String[] {"punch", "kick", "headbutt"},
                    new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();
            Area area = player.getCurrentArea();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(11) == 2) {
                        noun.drop(area);
                        System.out.println("You hit the " + noun.getName());
                        if (noun.getInside() != null) {
                            System.out.println("It dropped the " + noun.getInside().getName());
                        }
                        noun.drop(area);
                        area.removeItem(noun);
                    } else {
                        System.out.println("Now why would you do that?");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Inventory extends Verb {
        public Inventory() {
            super("inventory", new String[] {"i"}, new boolean[] {true, false, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();

            System.out.println(player.getName() + " has:");
            if (player.listInventory().length == 0) {
                System.out.println("\tNothing!");
            }
            for (Item listInventory : player.listInventory()) {
                System.out.println("\t" + listInventory.getName());
            }
        }
    }

    public static class Light extends Verb {
        public Light() {
            super("light", new String[] {"ignite", "illuminate"},
                    new boolean[] {false, true, false});
        }
    }

    public static class Listen extends Verb {
        public Listen() {
            super("listen", new String[] {"hear", "pay attention", "listen to"},
                    new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();
            Area area = player.getCurrentArea();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getSound() != null) {
                        System.out.println(noun.getSound());
                    } else {
                        System.out.println("It sounds like every other " + noun.getName()
                                + " you've ever heard");
                    }
                } else if (area.getSound() != null) {
                    System.out.println(area.getSound());
                } else {
                    System.out.println("It doesn't sound like anything");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Lock extends Verb {
        public Lock() {
            super("lock", new String[] {}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();
            World world = construct.getWorld();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    ArrayList<Item> keys = noun.getKey();
                    if (keys != null) {
                        boolean test = false;
                        for (int i = 0; i < player.listInventory().length; i++) {
                            if (player.listInventory()[i].getName().equals(keys.get(0).getName())) {
                                test = true;
                            }
                        }
                        if (noun.getUsageKey(5) == 2) {
                            if (test) {
                                noun.setUsageKey(5, 3);
                                System.out.println("You locked the " + noun.getName());
                                if (noun.getPortal() != null) {
                                    noun.getPortal().lock();
                                }
                                if (noun.hasMatching("door")) {
                                    noun.synchronizeDoor(world, player.getCurrentArea());
                                }
                            } else {
                                System.out.println("You need a key for that");
                            }
                        } else if (noun.getUsageKey(5) == 3) {
                            System.out.println("The " + noun.getName() + " is already locked!");
                        }
                    } else {
                        System.out.println("Now, how do you expect to do that?");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Look extends Verb {
        public Look() {
            super("look", new String[] {"l"}, new boolean[] {true, false, true});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();

            String[] desc;
            if (player.getCurrentArea().listItems().length == 0) {
                desc = new String[1];
                desc[0] = player.getCurrentArea().getDescription();
            } else {
                desc = new String[player.getCurrentArea().listItems().length + 3];
                desc[0] = player.getCurrentArea().getDescription();
                desc[1] = "";
                desc[2] = "This Area contains:";
                for (int i = 0; i < player.getCurrentArea().listItems().length; i++) {
                    desc[3 + i] = player.getCurrentArea().listItems()[i].getName();
                }
            }
            if (player.getCurrentArea().getDark() != true) {
                for (String item : desc) {
                    System.out.println(item);
                }
            } else if (player.getItem("Lantern") != null) {
                if (player.getItem("Lantern").getActive()) {
                    for (String item : desc) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("It's too dark to see!");
                }
            } else {
                System.out.println("It's too dark to see!");
            }
        }
    }

    public static class Make extends Verb {
        public Make() {
            super("make", new String[] {"create", "build", "construct"},
                    new boolean[] {false, true, false});
        }
    }

    public static class Move extends Verb {
        public Move() {
            super("move", new String[] {"go", "travel", "walk"},
                    new boolean[] {false, false, true});
        }

        public void run(Command command, Context construct) {
            int direction = command.getDirection();
            Player player = construct.getPlayer();
            World world = construct.getWorld();

            if (direction != -1) {
                if (player.getCurrentArea().getPortal(direction).isLocked()) {
                    System.out.println("You can't go that way!");
                } else if (!player.getSit()) {
                    player.setCurrentArea(world
                            .getArea(player.getCurrentArea().getPortal(direction).getTarget()));
                    System.out.print(player.getName() + " moved ");
                    if (direction == 0) {
                        System.out.println("north");
                    } else if (direction == 1) {
                        System.out.println("east");
                    } else if (direction == 2) {
                        System.out.println("south");
                    } else if (direction == 3) {
                        System.out.println("west");
                    } else if (direction == 4) {
                        System.out.println("northeast");
                    } else if (direction == 5) {
                        System.out.println("southeast");
                    } else if (direction == 6) {
                        System.out.println("southwest");
                    } else if (direction == 7) {
                        System.out.println("northwest");
                    } else if (direction == 8) {
                        System.out.println("up");
                    } else if (direction == 9) {
                        System.out.println("down");
                    }
                    player.getCurrentArea().enter(player);
                } else {
                    System.out.println("Ya gotta stand up first, stupid");
                }
            } else {
                System.out.println("Ya need a direction, ya dingus");
            }
        }
    }

    public static class Open extends Verb {
        public Open() {
            super("open", new String[] {"unseal"}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(4) == 2) {
                        if (noun.getUsageKey(5) != 3) {
                            noun.setUsageKey(4, 3);
                            System.out.println("You opened the " + noun.getName());
                        } else {
                            System.out.println(noun.getName() + " is locked");
                        }
                    } else if (noun.getUsageKey(4) == 3) {
                        System.out.println(noun.getName() + " is already open");
                    } else {
                        System.out.println("I don't see how you expect to do that");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Poke extends Verb {
        public Poke() {
            super("poke", new String[] {"touch", "prod", "tap", "feel"},
                    new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    System.out.println("You poked the " + noun.getName());
                    System.out.println("Good Job!");
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Pray extends Verb {
        public Pray() {
            super("pray", new String[] {"worship"}, new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();

            player.setPrayer(true);
            System.out.println(player.getName() + " prayed!");
        }
    }

    public static class Put extends Verb {
        public Put() {
            super("put", new String[] {"place", "set"}, new boolean[] {false, true, false});
        }
    }

    public static class Quit extends Verb {
        public Quit() {
            super("quit", new String[] {"q", "quit game"}, new boolean[] {true, false, false});
        }

        public void run(Command command, Context context) {
            Player player = context.getPlayer();
            System.out.println("Goodbye!");
            player.setDeath(Game.SELF_QUIT);
        }
    }

    public static class Read extends Verb {
        public Read() {
            super("read",
                    /* I dunno. What else would someone say? */
                    new String[] {"peruse", "study"}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(6) == 2) {
                        if (noun.getText() != null) {
                            System.out.println(noun.getText());
                        } else {
                            System.out.println("It says nothing important");
                        }
                    } else if (noun.getUsageKey(6) == 3) {
                        System.out.println("You can't quite make it out");
                    } else {
                        System.out.println("I don't see how you expect to do that");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Run extends Verb {
        public Run() {
            super("run", new String[] {"sprint", "jog", "gallop"},
                    new boolean[] {true, false, true});
        }
    }

    public static class Score extends Verb {
        public Score() {
            super("score", new String[] {"progress", "ranking", "rank"},
                    new boolean[] {true, false, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();

            System.out.println("Your score is: " + player.getScore());
        }
    }

    public static class Sell extends Verb {
        public Sell() {
            super("sell", new String[] {"barter", "bargain"}, new boolean[] {false, true, false});
        }
    }

    public static class Shout extends Verb {
        public Shout() {
            super("shout", new String[] {"scream", "yell"}, new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            System.out.println("Aaaarrrrrrrrgggggggggggggghhhhhhhhhhhhhh!");
        }
    }

    public static class Sit extends Verb {
        public Sit() {
            super("sit", new String[] {"lie down", "prone", "criss-cross applesauce"},
                    new boolean[] {true, false, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();

            player.setSit(true);
            System.out.println(player.getName() + " sat!");
        }
    }

    public static class Smell extends Verb {
        public Smell() {
            super("smell", new String[] {"sniff"}, new boolean[] {true, true, false});

        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();
            Area area = player.getCurrentArea();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getSmell() != null) {
                        System.out.println(noun.getSmell());
                    } else {
                        System.out.println("It smells like every other " + noun.getName()
                                + " you've ever smelled");
                    }
                } else if (area.getSmell() != null) {
                    System.out.println(area.getSmell());
                } else {
                    System.out.println("It doesn't smell like anything");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Stab extends Verb {
        public Stab() {
            super("stab", new String[] {"slice", "shank", "cut", "kill"},
                    new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();
            Area area = player.getCurrentArea();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    Item sword = new Sword();
                    boolean test = false;
                    for (int i = 0; i < player.listInventory().length; i++) {
                        if (player.listInventory()[i].getName().equals(sword.getName())) {
                            test = true;
                        }
                    }
                    if (test) {
                        if (noun.getUsageKey(11) == 2 || noun.getUsageKey(11) == 3) {
                            noun.drop(area);
                            System.out.println("You stabbed the " + noun.getName());
                            if (noun.getInside() != null) {
                                System.out.println("It dropped the " + noun.getInside().getName());
                            }
                            noun.drop(area);
                            area.removeItem(noun);
                        } else {
                            System.out.println("Now why would you do that?");
                        }
                    } else {
                        System.out.println("You need the " + sword.getName() + " to stab the "
                                + noun.getName());
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Stand extends Verb {
        public Stand() {
            super("stand", new String[] {"rise"}, new boolean[] {true, false, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();

            player.setSit(false);
            System.out.println(player.getName() + " stood!");
        }
    }

    public static class Suicide extends Verb {
        public Suicide() {
            super("suicide",
                    new String[] {"kill self", "orange monkey eagle", "orange eagle monkey",
                            "monkey orange eagle", "monkey eagle orange", "eagle orange monkey",
                            "eagle monkey orange", "commit suicide", "stab self"},
                    new boolean[] {true, false, false});
        }

        public void run(Command command, Context construct) {
            Player player = construct.getPlayer();
            player.setDeath(Game.SUICIDE);
            System.out.println("Whelp, goodbye, I guess");
            System.out.println(player.getName() + " commited suicide");
        }
    }

    public static class Take extends Verb {
        public Take() {
            super("take", new String[] {"get", "obtain", "pick up", "pickup", "steal"},
                    new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (player.getCurrentArea().hasMatching(noun)) {
                        if (noun.getUsageKey(1) == 1) {
                            player.getCurrentArea().removeItem(noun);
                            player.addItem(noun);
                            System.out.println(player.getName() + " took the " + noun.getName());
                        } else if (noun.getUsageKey(1) == 2) {
                            System.out.println("The " + noun.getName() + " is too heavy for that");
                        } else if (noun.getUsageKey(1) == 3) {
                            System.out.println("The " + noun.getName() + " is bolted down");
                        } else {
                            System.out.println("You can't take the " + noun.getName());
                        }
                    } else {
                        System.out.println("Where do you expect to find one of those?");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Talk extends Verb {
        public Talk() {
            super("talk",
                    //What if the player says "say hi to Mr. Potato"?
                    new String[] {"talk to", "converse", "speak to"},
                    //The purpose of this verb is to enable the player to interact
                    //with items. The fact that it only works with a noun is what
                    //distinguishes it from Shout.
                    new boolean[] {false, true, false});
        }
    }

    public static class Taste extends Verb {
        public Taste() {
            super("taste", new String[] {"lick", "sample"}, new boolean[] {true, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();
            Area area = player.getCurrentArea();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getTaste() != null) {
                        System.out.println(noun.getTaste());
                    } else {
                        System.out.println("It tastes like every other " + noun.getName()
                                + " you've ever tried");
                    }
                } else if (area.getTaste() != null) {
                    System.out.println(area.getTaste());
                } else {
                    System.out.println("It doesn't taste like anything");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class TurnOff extends Verb {
        public TurnOff() {
            super("turn off", new String[] {"deactivate"}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(7) == 3) {
                        noun.setUsageKey(7, 2);
                        System.out.println("You turned off the " + noun.getName());
                    } else if (noun.getUsageKey(7) == 2) {
                        System.out.println(noun.getName() + " is already off");
                    } else {
                        System.out.println("I don't see how you expect to do that");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class TurnOn extends Verb {
        public TurnOn() {
            super("turn on", new String[] {"activate"}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    if (noun.getUsageKey(7) == 2) {
                        noun.setUsageKey(7, 3);
                        System.out.println("You turned on the " + noun.getName());
                        if (player.getCurrentArea().getFirstVisit()) {
                            player.getCurrentArea().enter(player);
                        }
                    } else if (noun.getUsageKey(7) == 3) {
                        System.out.println(noun.getName() + " is already on");
                    } else {
                        System.out.println("I don't see how you expect to do that");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Unlock extends Verb {
        public Unlock() {
            super("unlock", new String[] {}, new boolean[] {false, true, false});
        }

        public void run(Command command, Context construct) {
            Item noun = command.getNoun();
            Player player = construct.getPlayer();
            World world = construct.getWorld();

            if (noun != null) {
                if (!noun.getName().equals("noItem")) {
                    ArrayList<Item> keys = noun.getKey();
                    if (keys != null) {
                        boolean test = false;
                        for (int i = 0; i < player.listInventory().length; i++) {
                            if (player.listInventory()[i].getName().equals(keys.get(0).getName())) {
                                test = true;
                            }
                        }
                        if (noun.getUsageKey(5) == 3) {
                            if (test) {
                                noun.setUsageKey(5, 2);
                                System.out.println("You unlocked the " + noun.getName());
                                if (noun.getPortal() != null) {
                                    noun.getPortal().unlock();
                                }
                                if (noun.hasMatching("door")) {
                                    noun.synchronizeDoor(world, player.getCurrentArea());
                                }
                            } else {
                                System.out.println("You need a key for that");
                            }
                        } else if (noun.getUsageKey(5) == 2) {
                            System.out.println("The " + noun.getName() + " is already unlocked!");
                        }
                    } else {
                        System.out.println("Now, how do you expect to do that?");
                    }
                } else {
                    System.out.println("Ya need a noun, ya dingus");
                }
            } else {
                System.out.println("Where do you expect to find one of those?");
            }
        }
    }

    public static class Write extends Verb {
        public Write() {
            super("write", new String[] {"inscribe", "draw", "transcribe"},
                    new boolean[] {true, true, false});
        }
    }
}
