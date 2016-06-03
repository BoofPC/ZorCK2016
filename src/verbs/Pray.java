package verbs;

import java.util.Arrays;

import core.*;

public class Pray extends Verb {

    public Pray() {
        super("pray",
                Arrays.asList("worship"),
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        player.setPrayer(true);
        System.out.println(player.getName() + " prayed!");
    }
}
