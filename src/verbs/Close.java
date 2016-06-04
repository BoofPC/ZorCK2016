package verbs;

import core.*;

public class Close extends Verb {

    public Close() {
        super("close", Verb.usage().noun(), "shut");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        if (usage.open() == Item.OPEN) {
            usage.open(Item.CLOSED);
            System.out.println("You closed the " + noun.name());
        } else if (usage.open() == Item.CLOSED) {
            System.out.println(noun.name() + " is already closed");
        } else {
            System.out.println("I don't see how you expect to do that");
        }
    }
}
