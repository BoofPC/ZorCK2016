package verbs;

import core.*;

/**
 * The purpose of this verb is to enable the player to interact with items. The fact that it only
 * works with a noun is what distinguishes it from Shout.
 */
public class Talk extends Verb {

    public Talk() {
        // What if the player says "say hi to Mr. Potato"?
        super("talk", Verb.usage().noun(), "talk to", "converse", "speak to");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        if (noun != null) {
            System.out.println(noun.name() + " isn't very talkative right now.");
        }
    }
}
