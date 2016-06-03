package verbs;

import java.util.Arrays;

import core.*;

public class Buy extends Verb {

    public Buy() {
        super("buy",
                Arrays.asList("purchase"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
