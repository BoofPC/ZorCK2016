package verbs;

import core.*;

public class Sell extends Verb {

    public Sell() {
        super("sell",
                new String[]{"barter", "bargain"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
