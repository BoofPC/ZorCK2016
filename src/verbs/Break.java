package verbs;

import core.*;

public class Break extends Verb {

    public Break() {
        super("break", Verb.usage().noun(), "shatter", "destroy");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Command.NounOrigin nounOrigin = command.getNounOrigin();
        final Item.Usage usage = noun.usage();

        switch (usage.breakable()) {
            case BREAKABLE:
                noun.usage().breakable(Item.BROKEN);
                switch (nounOrigin) {
                    case AREA:
                        System.out.println("You broke the " + noun.name());
                        break;
                    case PLAYER:
                        System.out.println("You broke your " + noun.name());
                        break;
                }
                break;
            default:
                System.out.println("I don't see how you expect to do that!");
                break;
        }
    }
}
