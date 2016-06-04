package verbs;

import core.*;

public class Make extends Verb {

    public Make() {
        super("make", Verb.usage().noun(), "create", "build", "construct");
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
