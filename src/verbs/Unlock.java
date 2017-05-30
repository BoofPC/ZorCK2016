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
                final List<Class<? extends Item>> keys = noun.keys();

                if (keys != null) {
                    final Player player = construct.getPlayer();
                    boolean test = false;
                    for (final Item item : player.getInventory()) {
                        if (keys.contains(item.getClass())) {
                            test = true;
                            break;
                        }
                    }
                    if (test) {
                        usage.lock(Item.UNLOCKED);
                        System.out.println("You unlocked the " + noun.name());
                        /* Hey, this doesn't actually unlock the portal.
                        *  TODO: Make this actually unlock the portal. */
                        if (noun.portal() != null) {
                            noun.portal().unlock();
                        }
                        /* synchronizeDoor is meant to sure that both sides of the door is unlocked,
                        *  but it's broken right now */
                        /*if (noun.hasMatching("door")) {
                            noun.synchronizeDoor(construct.getWorld(), player.getCurrentArea());
                        }*/
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
