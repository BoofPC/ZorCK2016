package verbs;

import core.*;

public class Read extends Verb {

    public Read() {
        super("read", Verb.usage().noun(), "peruse", "study");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        switch (noun.usage().read()) {
            case READABLE:
                if (noun.read() != null) {
                    System.out.println(noun.read());
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
