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
        final Player player = construct.getPlayer();

        if (usage.breakable() == Item.BREAKABLE) {
            switch (nounOrigin) {
                case AREA:
                    player.getCurrentArea()
                            .getItem(noun.name()).usage().breakable(Item.BROKEN);
                    System.out.println("You broke the " + noun.name());
                    break;
                case PLAYER:
                    player.getItem(noun.name()).usage().breakable(Item.BROKEN);
                    System.out.println("You broke your " + noun.name());
                    break;
            }
        } else {
            System.out.println("I don't see how you expect to do that!");
        }
    }
}
