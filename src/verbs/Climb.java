package verbs;

import core.*;
import core.World.Direction;

public class Climb extends Verb {

    public Climb() {
        super("climb", Verb.usage().bare().noun(), "scale");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();
        final Area currentArea = player.getCurrentArea();

        if (command.isBare()) {
            currentArea.interact(Command.directedBare(new Move(), Direction.UP, ""), construct);
        } else {
            final Item noun = command.getNoun();
            final Portal upPortal = currentArea.portals().up();
            if (noun.usage().climb() == Item.CLIMABLE && upPortal != null) {
                if (!upPortal.isLocked()) {
                    construct.getPlayer().getCurrentArea().interact(
                            Command.directedBare(new Climb(), Direction.UP, ""), construct);
                } else {
                    System.out.println("You can't climb that right now.");
                }
            } else {
                System.out.println("You can't climb that!");
            }
        }
    }
}
