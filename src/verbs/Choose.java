package verbs;

import java.util.Arrays;

import core.*;

public class Choose extends Verb {

    public Choose() {
        super("choose",
                Arrays.asList("select"),
                Verb.usage().noun().direction());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
