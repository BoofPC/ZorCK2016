package verbs;

import core.*;

public class Inventory extends Verb {

    public Inventory() {
        super("inventory", Verb.usage().bare(), "i");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        System.out.println(player.getName() + " has:");
        if (player.getInventory().size() == 0) {
            System.out.println("\tNothing!");
        }
        player.getInventory().forEach(i -> System.out.println("\t" + i.name()));
    }
}
