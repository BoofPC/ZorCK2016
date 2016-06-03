package verbs;

import java.util.Arrays;

import core.*;

public class Talk extends Verb {

    public Talk() {
        super("talk",
                // What if the player says "say hi to Mr. Potato"?
                Arrays.asList("talk to", "converse", "speak to"),
                // The purpose of this verb is to enable the player to interact
                // with items. The fact that it only works with a noun is what
                // distinguishes it from Shout.
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {

    }
}
