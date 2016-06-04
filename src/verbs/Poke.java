package verbs;

import java.util.Arrays;

import core.*;

public class Poke extends Verb {

    public Poke() {
        super("poke", Arrays.asList("touch", "prod", "tap", "feel"), Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        System.out.println("You poked the " + command.getNoun().name() + ".\n Good Job!");
    }
}
