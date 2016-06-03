package verbs;

import java.util.Arrays;

import core.*;

public class Poke extends Verb {

    public Poke() {
        super("poke",
                Arrays.asList("touch", "prod", "tap", "feel"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                System.out.println("You poked the " + noun.name());
                System.out.println("Good Job!");
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
