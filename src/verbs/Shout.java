package verbs;

import core.*;

public class Shout extends Verb {

    public Shout() {
        super("shout", Verb.usage().bare().noun(), "scream", "yell");
    }

    @Override
    public void run(final Command command, final Context construct) {
        System.out.println("Aaaarrrrrrrrgggggggggggggghhhhhhhhhhhhhh!");
    }
}
