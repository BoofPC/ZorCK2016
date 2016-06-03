package verbs;

import core.*;

public class Drink extends Verb {

    public Drink() {
        super("drink",
                new String[]{"sip", "quaff"},
                Verb.usage().noun());
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

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
