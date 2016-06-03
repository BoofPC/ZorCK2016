package verbs;

import java.util.Arrays;

import core.*;

public class Read extends Verb {

    public Read() {
        super("read",
                //I dunno. What else would someone say?
                Arrays.asList("peruse", "study"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                if (noun.usage().read() == Item.READABLE) {
                    if (noun.text() != null) {
                        System.out.println(noun.text());
                    } else {
                        System.out.println("It says nothing important");
                    }
                } else if (noun.usage().read() == Item.ILLEGIBLE) {
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
