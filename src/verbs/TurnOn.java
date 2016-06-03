package verbs;

import core.*;

public class TurnOn extends Verb {

    public TurnOn() {
        super("turn on",
                new String[]{"activate"},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.getUsageKey(7) == 2) {
                    noun.setUsageKey(7, 3);
                    System.out.println("You turned on the " + noun.getName());
                    if (player.getCurrentArea().getFirstVisit()) {
                        player.getCurrentArea().enter(player);
                    }
                } else if (noun.getUsageKey(7) == 3) {
                    System.out.println(noun.getName() + " is already on");
                } else {
                    System.out.println("I don't see how you expect to do that");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }

}
