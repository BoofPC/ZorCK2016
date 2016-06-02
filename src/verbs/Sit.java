package verbs;

import core.*;

/**
 *
 * @author johnson5951a
 */
public class Sit extends Verb {

    public Sit() {
        super("sit",
                new String[]{"lie down", "prone", "criss-cross applesauce"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context construct) {

    }
}
