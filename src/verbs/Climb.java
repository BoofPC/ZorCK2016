package verbs;

import core.*;
import core.World.Direction;

public class Climb extends Verb {

    public Climb() {
        super("climb",
                new String[]{"scale"},
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                final Portal upPortal = player.getCurrentArea().getPortals().up();
                if (noun.usage.climb() == Item.Usage.Climb.CLIMABLE && upPortal != null) {
                    if (!upPortal.isLocked()) {
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
