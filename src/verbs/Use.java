package verbs;

import core.*;

public class Use extends Verb {

    public Use() {
        super("use", Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        switch (usage.use()) {
            case USABLE:
                noun.interact(command, construct);
                break;
            default:
                System.out.println("I don't see how you expect to do that!");
                break;
        }

    }

}
