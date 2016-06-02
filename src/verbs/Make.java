package verbs;

import core.*;

public class Make extends Verb {

    public Make() {
        super("make",
                new String[]{"create", "build", "construct"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
