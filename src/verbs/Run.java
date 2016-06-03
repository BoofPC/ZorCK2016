package verbs;

import java.util.Arrays;

import core.*;

public class Run extends Verb {

    public Run() {
        super("run",
                Arrays.asList("sprint", "jog", "gallop"),
                Verb.usage().bare().direction());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
