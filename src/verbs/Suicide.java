package verbs;

import core.*;

// Killing yourself is a feature. They asked for it.
public class Suicide extends Verb {

    public Suicide() {
        super("suicide", Verb.usage().bare(), "kill self", "kill yourself", "orange monkey eagle",
                "commit suicide", "stab self");
    }

    @Override
    public void run(final Command command, final Context context) {
        final Player player = context.getPlayer();
        player.setDeath(Game.Status.SUICIDE);
        System.out.println("Whelp, goodbye, I guess");
        System.out.println(player.getName() + " commited suicide");
    }
}
