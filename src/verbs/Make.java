package verbs;

import core.*;

public class Make extends Verb {

    public Make() {
        super("make",
                new String[]{"create", "build", "construct"},
                Verb.usage().noun());
    }

    public void run(Command command, Context construct) {

    }
}
