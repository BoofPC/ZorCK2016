package verbs;

import core.*;

public class Sell extends Verb {

    public Sell() {
        super("sell",
                new String[]{"barter", "bargain"},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
