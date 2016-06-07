package verbs;

import core.*;

public class Stand extends Verb {

    public Stand() {
        super("stand", Verb.usage().bare(), "rise");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        player.setSit(false);
        System.out.println(player.getName() + " stood!");
    }
}
