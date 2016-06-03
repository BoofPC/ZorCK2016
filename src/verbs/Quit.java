package verbs;

import core.*;

public class Quit extends Verb {

    public Quit() {
        super("quit",
                new String[]{"q", "quit game"},
                Verb.usage().bare());
    }

    @Override
    public void run(final Command command, final Context context) {
        final Player player = context.getPlayer();
        System.out.println("Goodbye!");
        player.setDeath(Game.Status.SELF_QUIT);
    }
}
