package verbs;

import java.util.Arrays;

import core.*;

public class Shout extends Verb {

    public Shout() {
        super("shout",
                Arrays.asList("scream", "yell"),
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        System.out.println("Aaaarrrrrrrrgggggggggggggghhhhhhhhhhhhhh!");
    }
}
