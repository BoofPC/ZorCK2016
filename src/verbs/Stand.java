package verbs;

import core.*;

public class Stand extends Verb {

    public Stand() {
        super("stand",
                new String[]{"rise"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context construct) {
        int direction = command.getDirection();

        Player player = construct.getPlayer();
        World world = construct.getWorld();

        player.setSit(false);
        System.out.println(player.getName() + " stood!");
    }
}
