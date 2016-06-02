package verbs;

import core.*;

/**
 *
 * @author Pedro
 */
public class Quit extends Verb {

    public Quit() {
        super("quit",
                new String[]{"q", "quit game"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context context) {
        Player player = context.getPlayer();
        System.out.println("Goodbye!");
        player.setDeath(Game.SELF_QUIT);
    }
}