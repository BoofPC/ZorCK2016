package verbs;

import java.util.Arrays;

import core.*;

public class Inventory extends Verb {

    public Inventory() {
        super("inventory",
                Arrays.asList("i"),
                Verb.usage().bare());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        System.out.println(player.getName() + " has:");
        if (player.getInventory().size() == 0) {
            System.out.println("\tNothing!");
        }
        player.getInventory().forEach(i -> System.out.println("\t" + i.getName()));
    }
}
