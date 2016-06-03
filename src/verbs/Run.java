package verbs;

import core.*;

public class Run extends Verb {

    public Run() {
        super("run",
                new String[]{"sprint", "jog", "gallop"},
                Verb.usage().bare().direction());
    }

    public void run(Command command, Context construct) {

    }
}
