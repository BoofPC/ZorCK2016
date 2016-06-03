package verbs;

import core.*;

public class Choose extends Verb {

    public Choose() {
        super("choose",
                new String[]{"select"},
                Verb.usage().noun().direction());
    }

    public void run(Command command, Context construct) {

    }
}
