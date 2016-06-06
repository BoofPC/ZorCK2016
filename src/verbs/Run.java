package verbs;

import core.*;
import core.World.Direction;

public class Run extends Verb {

    public Run() {
        super("run", Verb.usage().direction(), "sprint", "jog", "hustle");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Direction direction = command.getDirection();
        final Player player = construct.getPlayer();
        final Portal portal = player.getCurrentArea().portals().getPortal(direction);

        if (portal.isLocked()) {
            System.out.println("You can't go that way!");
        } else if (!player.getSit()) {
            player.setCurrentArea(construct.getWorld().getArea(portal.getTarget()));
            System.out.print(player.getName() + " moved ");
            switch (direction) {
                case NORTH:
                    System.out.println("north");
                    break;
                case EAST:
                    System.out.println("east");
                    break;
                case SOUTH:
                    System.out.println("south");
                    break;
                case WEST:
                    System.out.println("west");
                    break;
                case NORTHEAST:
                    System.out.println("northeast");
                    break;
                case SOUTHEAST:
                    System.out.println("southeast");
                    break;
                case SOUTHWEST:
                    System.out.println("southwest");
                    break;
                case NORTHWEST:
                    System.out.println("northwest");
                    break;
                case UP:
                    System.out.println("up");
                    break;
                case DOWN:
                    System.out.println("down");
                    break;
            }
            player.getCurrentArea().enter(player);
        } else if (player.getSit()) {
            System.out.println("Ya gotta stand up first, stupid");
        }
    }
}
