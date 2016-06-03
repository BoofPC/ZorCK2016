package verbs;

import core.*;

public class Climb extends Verb {

    public Climb() {
        super("climb",
                new String[]{"scale"},
                new boolean[]{true, true, false});
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        Item noun = command.getNoun();

        Player player = construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.getUsageKey(13) == 2 && player.getCurrentArea().getPortals().getPortal(8)
                        != null) {
                    if (!player.getCurrentArea().getPortals().getPortal(8).isLocked()) {
                        construct.getPlayer().getCurrentArea().interact(new Command(new Move(), null, 8), construct);
                    } else {
                        System.out.println("You can't climb that!");
                    }
                } else {
                    System.out.println("You can't climb that!");
                }
            } else {
                construct.getPlayer().getCurrentArea().interact(new Command(new Move(), null, 8), construct);
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
