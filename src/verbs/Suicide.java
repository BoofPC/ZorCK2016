package verbs;

import core.*;

// Killing yourself is a feature. They asked for it.
public class Suicide extends Verb {

    public Suicide() {
        super("suicide",
                new String[]{"kill self", "kill yourself","orange monkey eagle", "commit suicide", "stab self"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context context) {
        Player player = context.getPlayer();
        player.setDeath(Game.SUICIDE);
        System.out.println("Whelp, goodbye, I guess");
        System.out.println(player.getName() + " commited suicide");
    }
}
