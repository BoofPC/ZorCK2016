package verbs;

import core.*;

public class Choose extends Verb {

    public Choose() {
        super("choose",
                new String[]{"select"},
                new boolean[]{false, true, true});
    }

    public void run(Command command, Context construct) {

    }
}
