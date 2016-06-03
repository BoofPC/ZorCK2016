package verbs;

import core.*;
import core.World.Direction;

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
                if (noun.getUsageKey(13) == 2 && player.getCurrentArea().getPortals().getPortal(Direction.UP)
                        != null) {
                    if (!player.getCurrentArea().getPortals().getPortal(Direction.UP).isLocked()) {
                        construct.getPlayer().getCurrentArea().interact(new Command(new Move(), null, Direction.UP), construct);
                    } else {
                        System.out.println("You can't climb that!");
                    }
                } else {
                    System.out.println("You can't climb that!");
                }
            } else {
                construct.getPlayer().getCurrentArea().interact(new Command(new Move(), null, Direction.UP), construct);
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
