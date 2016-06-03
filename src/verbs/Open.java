package verbs;

import core.*;

public class Open extends Verb {

    public Open() {
        super("open",
                new String[]{"unseal"},
                Verb.usage().noun());
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

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
