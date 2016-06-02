package verbs;

import core.*;

/**
 *
 * @author Samantha
 */

//killing yourself is a feature in the actual Zork game
//if you are offended by this, feel free to delete this class
public class Suicide extends Verb {

    public Suicide() {
        super("suicide",
                new String[]{"kill self", "kill yourslef","orange monkey eagle", "commit suicide", "stab self"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context context) {
        Player player = context.getPlayer();
        player.setDeath(Game.SUICIDE);
        System.out.println("Whelp, goodbye, I guess");
        System.out.println(player.getName() + " commited suicide");
    }
}
