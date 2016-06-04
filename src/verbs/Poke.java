package verbs;

import core.*;

public class Poke extends Verb {

    public Poke() {
        super("poke", Verb.usage().noun(), "touch", "prod", "tap", "feel");
    }

    @Override
    public void run(final Command command, final Context construct) {
        System.out.println("You poked the " + command.getNoun().name() + ".\n Good Job!");
    }
}
