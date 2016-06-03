package verbs;

import core.*;

public class Put extends Verb {

    public Put() {
        super("put",
                new String[]{"place", "set"},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
