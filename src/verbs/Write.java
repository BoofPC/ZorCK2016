package verbs;

import core.*;

/**
 *
 * @author johnson5951a
 */
public class Write extends Verb {

    public Write() {
        super("write",
                new String[]{"inscribe", "draw", "transcribe"},
                new boolean[]{true, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
