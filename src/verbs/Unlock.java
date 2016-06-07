package verbs;

import core.*;

import java.util.List;

public class Unlock extends Verb {

    public Unlock() {
        super("unlock", Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        switch (usage.lock()) {
            case LOCKED:
                final List<String> keys = noun.keys();

                if (keys != null) {
                    final Player player = construct.getPlayer();
                    boolean test = false;
                    for (final Item item : player.getInventory()) {
                        if (keys.contains(item)) {
                            test = true;
                            break;
                        }
                    }
                    if (test) {
                        usage.lock(Item.UNLOCKED);
                        System.out.println("You unlocked the " + noun.name());
                        final Portal portal = noun.portal();
                        if (portal != null) {
                            portal.unlock();
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
            case UNLOCKED:
                System.out.println("The " + noun.name() + " is already unlocked!");
                break;
            case NO_LOCK:
                System.out.println("Now, how do you expect to do that?");
                break;
        }
    }

}
