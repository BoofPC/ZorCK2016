package verbs;

import core.*;

public class Quit extends Verb {

    public Quit() {
        super("quit", Verb.usage().bare(), "q", "quit game");
    }

    @Override
    public void run(final Command command, final Context context) {
        final Player player = context.getPlayer();
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
//