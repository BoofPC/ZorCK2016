package verbs;

import core.*;

public class Shout extends Verb {

    public Shout() {
        super("shout",
                new String[]{"scream", "yell"},
                new boolean[]{true, true, false});
    }

    public void run(Command command, Context construct) {
        System.out.println("Aaaarrrrrrrrgggggggggggggghhhhhhhhhhhhhh!");
    }
}
