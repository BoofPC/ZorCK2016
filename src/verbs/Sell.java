package verbs;

import core.*;

/**
 *
 * @author johnson5951a
 */
public class Sell extends Verb {

    public Sell() {
        super("sell",
                new String[]{"barter", "bargain"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
