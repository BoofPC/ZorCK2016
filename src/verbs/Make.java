package verbs;

import core.*;

public class Make extends Verb {

    public Make() {
        super("make",
                new String[]{"create", "build", "construct"},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
