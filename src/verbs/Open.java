package verbs;

import java.util.Arrays;

import core.*;

public class Open extends Verb {

    public Open() {
        super("open", Arrays.asList("unseal"), Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        switch (usage.open()) {
            case CLOSED:
                if (usage.lock() != Item.LOCKED) {
                    usage.open(Item.OPEN);
                    System.out.println("You opened the " + noun.name());
                } else {
                    System.out.println(noun.name() + " is locked");
                }
                break;
            case OPEN:
                System.out.println(noun.name() + " is already open");
                break;
            case UNOPENABLE:
                System.out.println("I don't see how you expect to do that");
                break;
        }
    }
}
