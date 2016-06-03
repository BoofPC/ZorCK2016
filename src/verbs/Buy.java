package verbs;

import core.*;

public class Buy extends Verb {

    public Buy() {
        super("buy",
                new String[]{"purchase"},
                Verb.usage().noun());
    }

    public void run(Command command, Context construct) {

    }
}
