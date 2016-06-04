package verbs;

import java.util.Arrays;

import core.*;

public class Examine extends Verb {

    public Examine() {
        super("examine", Arrays.asList("x", "look at", "scan", "study", "observe"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        final String description = noun.description();
        if (description != null) {
            System.out.println(description);
        } else {
            System.out.println("It looks like every other " + noun.name() + " you've ever seen");
        }

    }

}
