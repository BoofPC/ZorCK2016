package verbs;

import core.*;

public class Diagnostic extends Verb {

    public Diagnostic() {
        super("diagnostic",
                new String[]{"status", "health"},
                Verb.usage().bare());
    }

    public void run(Command command, Context construct) {
        Player player = construct.getPlayer();

        System.out.println("\tHealth: " + player.getHp() + " / "
                + player.getMaxHp());
    }
}
