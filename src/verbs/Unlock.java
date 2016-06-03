package verbs;

import core.*;
import java.util.List;

public class Unlock extends Verb {

    public Unlock() {
        super("unlock",
                new String[]{},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        final World world = construct.getWorld();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                final List<String> keys = noun.getKeys();
                if (keys != null) {
                    boolean test = false;
                    for (final Item item : player.getInventory()) {
                        if (item.getName().equals(keys.get(0))) {
                            test = true;
                        }
                    }
                    if (noun.getUsageKey(5) == 3) {
                        if (test) {
                            noun.setUsageKey(5, 2);
                            System.out.println("You unlocked the " + noun.getName());
                            if (noun.getPortal() != null) {
                                noun.getPortal().unlock();
                            }
                            if (noun.hasMatching("door")) {
                                noun.synchronizeDoor(world, player.getCurrentArea());
                            }
                        } else {
                            System.out.println("You need a key for that");
                        }
                    } else if (noun.getUsageKey(5) == 2) {
                        System.out.println("The " + noun.getName() + " is already unlocked!");
                    }
                } else {
                    System.out.println("Now, how do you expect to do that?");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }

}
