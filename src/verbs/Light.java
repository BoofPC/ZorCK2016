package verbs;

import core.Command;
import core.Context;
import core.Verb;

public class Light extends Verb {

    public Light() {
        super("light", Verb.usage().noun(), "ignite", "illuminate");
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
