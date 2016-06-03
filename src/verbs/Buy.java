package verbs;

import core.*;

public class Buy extends Verb {

    public Buy() {
        super("buy",
                new String[]{"purchase"},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
