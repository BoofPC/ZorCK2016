package verbs;

import core.*;

public class Write extends Verb {

    public Write() {
        super("write",
                new String[]{"inscribe", "draw", "transcribe"},
                new boolean[]{true, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
