package verbs;

import core.*;

public class Choose extends Verb {

    public Choose() {
        super("choose", Verb.usage().noun().direction(), "select");
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
