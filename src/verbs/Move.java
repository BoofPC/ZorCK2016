package verbs;

import core.*;
import core.World.Direction;
import items.Scissors;

public class Move extends Verb {

    public Move() {
        super("move", Verb.usage().direction(), "go", "travel", "walk", "run", "sprint", "jog",
                "hustle", "trot", "skip", "prance", "move it on out");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Direction direction = command.getDirection();
        final Player player = construct.getPlayer();
        final Portal portal = player.getCurrentArea().portals().getPortal(direction);

        if (player.hasItem(Scissors.class) && !command.getVerbStr().equals("walk")) {
            player.setDeath(Game.Status.DIE);
            System.out.println("Didn't your mother ever tell you not to run with scissors?");
            return;
        }

        if (portal.isLocked()) {
            System.out.println("You can't go that way!");
        } else if (!player.getSit()) {
            player.setCurrentArea(construct.getWorld().getArea(portal.getTarget()));
            player.getCurrentArea().enter(player);
        } else if (player.getSit()) {
            System.out.println("Ya gotta stand up first, stupid");
        }
    }
}
