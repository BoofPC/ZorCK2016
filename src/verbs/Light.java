package verbs;

import core.Command;
import core.Context;
import core.Verb;

/**
 *
 * @author johnson5951a
 */
public class Light extends Verb {

    public Light() {
        super("light",
                new String[]{"ignite", "illuminate"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
