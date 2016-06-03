package verbs;

import java.util.Arrays;

import core.*;

public class Sell extends Verb {

    public Sell() {
        super("sell",
                Arrays.asList("barter", "bargain"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
