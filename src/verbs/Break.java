package verbs;

import core.*;

public class Break extends Verb {

    public Break() {
        super("break",
                new String[]{"shatter", "destroy"},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        construct.getPlayer();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.usage.breakable() == Item.Usage.Breakable.UNBROKEN) {
                    // TODO: find a better way to destroy something
                    noun.usage.visible(Item.Usage.Visible.HIDDEN)
                        .breakable(Item.Usage.Breakable.BROKEN);
                    System.out.println("You broke the " + noun.getName());
                } else if (noun.usage.breakable() == Item.Usage.Breakable.BROKEN) {
                    System.out.println("The " + noun.getName()
                            + " is already broken.");
                } else {
                    System.out.println("You can't break the " + noun.getName());
                }
            } else {
                System.out.println("Ya need a noun, ya dingus.");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }

    }
}
