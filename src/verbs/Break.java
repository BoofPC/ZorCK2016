package verbs;

import core.*;

public class Break extends Verb {

    public Break() {
        super("break",
                new String[]{"shatter", "destroy"},
                Verb.usage().noun());
    }

    public void run(Command command, Context construct) {
        Item noun = command.getNoun();
        construct.getPlayer();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.getUsageKey(15) == 2) {
                    // TODO: find a better way to destroy something
                    noun.setUsageKey(0, 2);
                    noun.setUsageKey(15, 3);
                    System.out.println("You broke the " + noun.getName());
                } else if (noun.getUsageKey(0) == 3) {
                    System.out.println("The " + noun.getName()
                            + " is already broken.");
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
