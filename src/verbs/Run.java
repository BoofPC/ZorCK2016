package verbs;

import core.*;

public class Run extends Verb {

    public Run() {
        super("run", Verb.usage().bare().direction(), "sprint", "jog", "gallop");
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
