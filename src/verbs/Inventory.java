package verbs;

import core.*;

/**
 *
 * @author Pedro
 */
public class Inventory extends Verb {

    public Inventory() {
        super("inventory",
                new String[]{"i"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context construct) {
        int direction = command.getDirection();
        Item noun = command.getNoun();

        Player player = construct.getPlayer();
        World world = construct.getWorld();

        System.out.println(player.getName() + " has:");
        if (player.listInventory().length == 0) {
            System.out.println("\tNothing!");
        }
        for (Item listInventory : player.listInventory()) {
            System.out.println("\t" + listInventory.getName());
        }
    }
}
