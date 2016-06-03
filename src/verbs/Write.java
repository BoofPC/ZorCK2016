package verbs;

import java.util.Arrays;

import core.*;

public class Write extends Verb {

    public Write() {
        super("write",
                Arrays.asList("inscribe", "draw", "transcribe"),
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
