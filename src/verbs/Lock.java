package verbs;

import core.*;

import java.util.Arrays;
import java.util.List;

public class Lock extends Verb {

    public Lock() {
        super("lock", Arrays.asList(), Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        switch (usage.lock()) {
            case UNLOCKED:
                final List<String> keys = noun.keys();

                if (keys != null) {
                    final Player player = construct.getPlayer();
                    boolean test = false;
                    for (final Item item : player.getInventory()) {
                        if (keys.contains(item.name())) {
                            test = true;
                            break;
                        }
                    }
                    if (test) {
                        usage.lock(Item.LOCKED);
                        System.out.println("You locked the " + noun.name());
                        final Portal portal = noun.getPortal();
                        if (portal != null) {
                            portal.lock();
                        }
                        if (noun.hasMatching("door")) {
                            noun.synchronizeDoor(construct.getWorld(), player.getCurrentArea());
                        }
                    } else {
                        System.out.println("You need a key for that");
                    }
                } else {
                    System.out.println("Now, how do you expect to do that?");
                }
                break;
            case LOCKED:
                System.out.println("The " + noun.name() + " is already locked!");
                break;
            case NO_LOCK:
                System.out.println("Now, how do you expect to do that?");
                break;
        }
    }

}
