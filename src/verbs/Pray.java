package verbs;

import core.*;

public class Pray extends Verb {

    public Pray() {
        super("pray", Verb.usage().bare().noun(), "worship");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        player.setPrayer(true);
        System.out.println(player.getName() + " prayed!");
    }
}
