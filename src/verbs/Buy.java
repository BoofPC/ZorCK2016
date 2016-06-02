package verbs;

import core.*;

public class Buy extends Verb {

    public Buy() {
        super("buy",
                new String[]{"purchase"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
