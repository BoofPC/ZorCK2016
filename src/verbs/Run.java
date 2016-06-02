package verbs;

import core.*;

public class Run extends Verb {

    public Run() {
        super("run",
                new String[]{"sprint", "jog", "gallop"},
                new boolean[]{true, false, true});
    }

    public void run(Command command, Context construct) {

    }
}
