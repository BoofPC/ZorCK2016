package verbs;

import core.*;

public class Pray extends Verb {

    public Pray() {
        super("pray",
                new String[]{"worship"},
                Verb.usage().bare().noun());
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        command.getNoun();

        Player player = construct.getPlayer();
        construct.getWorld();

        player.setPrayer(true);
        System.out.println(player.getName() + " prayed!");
    }
}
