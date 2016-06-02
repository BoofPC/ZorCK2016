package verbs;

import core.*;

public class Read extends Verb {

    public Read() {
        super("read",
                //I dunno. What else would someone say?
                new String[]{"peruse", "study"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

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
