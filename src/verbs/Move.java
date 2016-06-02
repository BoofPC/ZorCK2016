package verbs;

import core.*;

/**
 *
 * @author keith5387h
 */
public class Move extends Verb {

    public Move() {
        super("move",
                new String[]{"go", "travel", "walk"},
                new boolean[]{false, false, true});
    }

    public void run(Command command, Context construct) {
        int direction = command.getDirection();
        Item noun = command.getNoun();

        Player player = construct.getPlayer();
        World world = construct.getWorld();

        if (direction != -1) {
            if (player.getCurrentArea().getPortal(direction).isLocked()) {
                System.out.println("You can't go that way!");
            } else {
                player.setCurrentArea(world.getArea(player.getCurrentArea()
                        .getPortal(direction).getTarget()));
                System.out.print(player.getName() + " moved ");
                if (direction == 0) {
                    System.out.println("north");
                } else if (direction == 1) {
                    System.out.println("east");
                } else if (direction == 2) {
                    System.out.println("south");
                } else if (direction == 3) {
                    System.out.println("west");
                } else if (direction == 4) {
                    System.out.println("northeast");
                } else if (direction == 5) {
                    System.out.println("southeast");
                } else if (direction == 6) {
                    System.out.println("southwest");
                } else if (direction == 7) {
                    System.out.println("northwest");
                } else if (direction == 8) {
                    System.out.println("up");
                } else if (direction == 9) {
                    System.out.println("down");
                }
                player.getCurrentArea().enter(player);
            }
        } else {
            System.out.println("Ya need a direction, ya dingus");
        }
    }
}
