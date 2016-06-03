package verbs;

import java.util.Arrays;

import core.*;

public class Stand extends Verb {

    public Stand() {
        super("stand",
                Arrays.asList("rise"),
                Verb.usage().bare());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();

        final Player player = construct.getPlayer();
        construct.getWorld();

        player.setSit(false);
        System.out.println(player.getName() + " stood!");
    }
}
