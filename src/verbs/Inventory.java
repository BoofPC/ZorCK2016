package verbs;

import core.*;

public class Inventory extends Verb {

    public Inventory() {
        super("inventory",
                new String[]{"i"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        command.getNoun();

        Player player = construct.getPlayer();
        construct.getWorld();

        System.out.println(player.getName() + " has:");
        if (player.getInventory().size() == 0) {
            System.out.println("\tNothing!");
        }
        player.getInventory().forEach(i -> System.out.println("\t" + i.getName()));
    }
}
