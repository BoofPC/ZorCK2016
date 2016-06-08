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
            currentArea.interact(Command.directedBare(new Move(), "climb", Direction.UP, "up", ""),
                    construct);
        } else {
            final Item noun = command.getNoun();
            final Portal upPortal = currentArea.portals().up();
            switch (noun.usage().climb()) {
                case CLIMABLE:
                    if (upPortal != null) {
                        if (!upPortal.isLocked()) {
                            construct.getPlayer().getCurrentArea().interact(Command.directedBare(
                                    new Climb(), "climb", Direction.UP, "up", ""), construct);
                        } else {
                            System.out.println("You can't climb that right now.");
                        }
                    } else {
                        System.out.println("You can't climb that!");
                    }
                    break;
                default:
                    System.out.println("You can't climb that!");
                    break;
            }
        }
    }
}
