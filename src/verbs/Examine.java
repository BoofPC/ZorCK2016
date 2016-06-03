package verbs;

import java.util.Arrays;

import core.*;

public class Examine extends Verb {

    public Examine() {
        super("examine",
                Arrays.asList("look at", "scan", "study", "observe"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                if (noun.description() != null) {
                    System.out.println(noun.description());
                } else {
                    System.out.println("It looks like every other "
                            + noun.name() + " you've ever seen");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }

    }

}
