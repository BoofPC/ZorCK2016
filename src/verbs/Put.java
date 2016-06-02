package verbs;

import core.*;

/**
 *
 * @author johnson5951a
 */
public class Put extends Verb {

    public Put() {
        super("put",
                new String[]{"place", "set"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
