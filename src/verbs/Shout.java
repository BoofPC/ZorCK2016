package verbs;

import core.*;

public class Shout extends Verb {

    public Shout() {
        super("shout",
                new String[]{"scream", "yell"},
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        System.out.println("Aaaarrrrrrrrgggggggggggggghhhhhhhhhhhhhh!");
    }
}
