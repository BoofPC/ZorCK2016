package verbs;

import core.*;

public class Put extends Verb {

    public Put() {
        super("put", Verb.usage().noun(), "place", "set");
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
