package verbs;

import core.*;

public class Diagnostic extends Verb {

    public Diagnostic() {
        super("diagnostic", Verb.usage().bare(), "status", "health");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        System.out.println("\tHealth: " + player.getHp() + " / " + player.getMaxHp());
    }
}
