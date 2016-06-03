package verbs;

import core.*;

public class Put extends Verb {

    public Put() {
        super("put",
                new String[]{"place", "set"},
                Verb.usage().noun());
    }

    public void run(Command command, Context construct) {

    }
}
