package verbs;

import java.util.Arrays;

import core.*;

public class Diagnostic extends Verb {

    public Diagnostic() {
        super("diagnostic",
                Arrays.asList("status", "health"),
                Verb.usage().bare());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        System.out.println("\tHealth: " + player.getHp() + " / "
                + player.getMaxHp());
    }
}
