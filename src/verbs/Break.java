package verbs;

import core.*;

public class Break extends Verb {

    public Break() {
        super("break", Verb.usage().noun(), "shatter", "destroy");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        if (noun.usage().breakable() == Item.UNBROKEN) {
            // TODO: find a better way to destroy something
            noun.usage().visible(Item.HIDDEN).breakable(Item.BROKEN);
            System.out.println("You broke the " + noun.name());
        } else if (noun.usage().breakable() == Item.BROKEN) {
            System.out.println("The " + noun.name() + " is already broken.");
        } else {
            System.out.println("You can't break the " + noun.name());
        }
    }
}
