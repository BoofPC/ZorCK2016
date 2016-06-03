package verbs;

import java.util.Arrays;

import core.*;
import core.World.Direction;

public class Climb extends Verb {

    public Climb() {
        super("climb",
                Arrays.asList("scale"),
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                final Portal upPortal = player.getCurrentArea().getPortals().up();
                if (noun.usage().climb() == Item.CLIMABLE && upPortal != null) {
                    if (!upPortal.isLocked()) {
                        construct.getPlayer().getCurrentArea().interact(Command.directedBare(new Climb(), Direction.UP, ""), construct);
                    } else {
                        System.out.println("You can't climb that!");
                    }
                } else {
                    System.out.println("You can't climb that!");
                }
            } else {
                construct.getPlayer().getCurrentArea().interact(Command.directedBare(new Move(), Direction.UP, ""), construct);
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
