package verbs;

import core.*;

public class Sell extends Verb {

    public Sell() {
        super("sell",
                new String[]{"barter", "bargain"},
                Verb.usage().noun());
    }

    public void run(Command command, Context construct) {

    }
}
