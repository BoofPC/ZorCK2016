package verbs;

import core.*;

public class Run extends Verb {

    public Run() {
        super("run",
                new String[]{"sprint", "jog", "gallop"},
                Verb.usage().bare().direction());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
