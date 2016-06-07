package verbs;

import core.*;

public class Take extends Verb {

    public Take() {
        super("take", Verb.usage().noun(), "get", "obtain", "pick up", "pickup", "steal");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();

        if (player.getCurrentArea().hasMatching(noun)) {
            if (noun.usage().take() == Item.TAKABLE) {
                player.getCurrentArea().removeItem(noun);
                player.addItem(noun);
                System.out.println(player.getName() + " took the " + noun.name());
            } else if (noun.usage().take() == Item.TOO_HEAVY) {
                System.out.println("The " + noun.name() + " is too heavy for that");
            } else if (noun.usage().take() == Item.BOLTED_DOWN) {
                System.out.println("The " + noun.name() + " is bolted down");
            } else {
                System.out.println("You can't take the " + noun.name());
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
