package verbs;

import java.util.Arrays;

import core.Command;
import core.Context;
import core.Verb;

public class Light extends Verb {

    public Light() {
        super("light",
                Arrays.asList("ignite", "illuminate"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
