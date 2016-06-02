package verbs;

import core.*;

/**
 *
 * @author Samantha
 */
public class Diagnostic extends Verb {

    public Diagnostic() {
        super("diagnostic",
                new String[]{"status", "health"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context construct) {
        Player player = construct.getPlayer();

        System.out.println("\tHealth: " + player.getHp() + " / "
                + player.getMaxHp());
    }
}
