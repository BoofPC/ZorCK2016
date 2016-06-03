package verbs;

import java.util.Arrays;

import core.*;

public class Drop extends Verb {

    public Drop() {
        super("drop",
                Arrays.asList("release", "throw out", "toss", "leave"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();

        if (player.hasMatching(noun)) {
            if (noun.usage().take() == Item.TAKABLE) {
                player.removeItem(noun);
                player.getCurrentArea().addItem(noun);
                System.out.println("You dropped " + noun.name());
            } else {
                System.out.println("I'm sorry " + player.getName()
                        + ", I can't allow you to do that");
            }
        } else {
            System.out.println("You don't have the " + noun.name());
        }
    }
}
