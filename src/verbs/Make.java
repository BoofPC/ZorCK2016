package verbs;

import core.*;

/**
 *
 * @author johnson5951a
 */
public class Make extends Verb {

    public Make() {
        super("make",
                new String[]{"create", "build", "construct"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
