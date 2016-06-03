package verbs;

import java.util.Arrays;

import core.*;

public class Eat extends Verb {

    public Eat() {
        super("eat",
                Arrays.asList("consume", "devour", "ingest"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();

        if (noun.usage().food() == Item.Usage.Food.EDIBLE) {
            if (player.getCurrentArea().hasMatching(noun)) {
                player.getCurrentArea().removeItem(noun);
            } else if (player.hasMatching(noun)) {
                player.removeItem(noun);
            }
            System.out.println(player.getName() + " ate the " + noun.getName());
            if (noun.getTaste() != null) {
                System.out.println(noun.getTaste());
            } else {
                System.out.println("It tastes like every other "
                        + noun.getName() + " you've ever eaten");
            }
        } else {
            System.out.println("I don't see how you expect to do that!");
        }
    }
}
