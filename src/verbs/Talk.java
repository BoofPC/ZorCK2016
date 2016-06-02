package verbs;

import core.*;

/**
 *
 * @author johnson5951a & Samantha
 */
public class Talk extends Verb {

    public Talk() {
        super("talk",
                //What if the player says "say hi to Mr. Potato"?
                new String[]{"talk to", "converse", "speak to"},
                //The purpose of this verb is to enable the player to interact
                //with items. The fact that it only works with a noun is what
                //distinguishes it from Shout.
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {

    }
}
