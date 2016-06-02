package verbs;

import core.*;

public class Examine extends Verb {

    public Examine() {
        super("examine",
                new String[]{"look at", "scan", "study", "observe"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {
        Item noun = command.getNoun();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.getDescription() != null) {
                    System.out.println(noun.getDescription());
                } else {
                    System.out.println("It looks like every other "
                            + noun.getName() + " you've ever seen");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }

    }

}
