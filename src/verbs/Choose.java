package verbs;

import core.*;

public class Choose extends Verb {

    public Choose() {
        super("choose",
                new String[]{"select"},
                Verb.usage().noun().direction());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
