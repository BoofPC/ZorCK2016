package verbs;

import core.*;

public class Write extends Verb {

    public Write() {
        super("write",
                new String[]{"inscribe", "draw", "transcribe"},
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
