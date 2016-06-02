package verbs;

import core.*;

public class Put extends Verb {

    public Put() {
        super("put",
                new String[]{"place", "set"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
