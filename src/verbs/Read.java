package verbs;

import java.util.Arrays;

import core.*;

public class Read extends Verb {

    public Read() {
        super("read", Arrays.asList("peruse", "study"), Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        switch (noun.usage().read()) {
            case READABLE:
                if (noun.text() != null) {
                    System.out.println(noun.text());
                } else {
                    System.out.println("It says nothing important.");
                }
                break;
            case ILLEGIBLE:
                System.out.println("You can't quite make it out.");
                break;
            case UNREADABLE:
                System.out.println("I don't see how you expect to do that.");
                break;
        }
    }
}
