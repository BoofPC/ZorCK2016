package verbs;

import java.util.Arrays;

import core.*;

public class Make extends Verb {

    public Make() {
        super("make",
                Arrays.asList("create", "build", "construct"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
