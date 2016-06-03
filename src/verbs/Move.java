package verbs;

import core.*;
import core.World.Direction;

public class Move extends Verb {

    public Move() {
        super("move",
                new String[]{"go", "travel", "walk"},
                Verb.usage().direction());
    }

    public void run(Command command, Context construct) {
        Direction direction = command.getDirection();
        command.getNoun();

        Player player = construct.getPlayer();
        World world = construct.getWorld();

        if (direction != null) {
            final Portal portal = player.getCurrentArea().getPortals().getPortal(direction);
            if (portal.isLocked()) {
                System.out.println("You can't go that way!");
            } else if(!player.getSit()){
                player.setCurrentArea(world.getArea(portal.getTarget()));
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
            }else if(player.getSit()){
                System.out.println("Ya gotta stand up first, stupid");
            }
        } else {
            System.out.println("Ya need a direction, ya dingus");
        }
    }
}
