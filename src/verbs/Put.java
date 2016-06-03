package verbs;

import java.util.Arrays;

import core.*;

public class Put extends Verb {

    public Put() {
        super("put",
                Arrays.asList("place", "set"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
