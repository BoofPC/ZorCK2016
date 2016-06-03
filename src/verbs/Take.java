package verbs;

import java.util.Arrays;

import core.*;

public class Take extends Verb {

    public Take() {
        super("take",
                Arrays.asList("get", "obtain", "pick up", "pickup", "steal"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                if (player.getCurrentArea().hasMatching(noun)) {
                    if (noun.usage().take() == Item.Usage.Take.TAKABLE) {
                        player.getCurrentArea().removeItem(noun);
                        player.addItem(noun);
                        System.out.println(player.getName() + " took the "
                                + noun.name());
                    } else if (noun.usage().take() == Item.Usage.Take.TOO_HEAVY) {
                        System.out.println("The " + noun.name()
                                + " is too heavy for that");
                    } else if (noun.usage().take() == Item.Usage.Take.BOLTED_DOWN) {
                        System.out.println("The " + noun.name() + " is bolted down");
                    } else {
                        System.out.println("You can't take the " + noun.name());
                    }
                } else {
                    System.out.println("Where do you expect to find one of those?");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
