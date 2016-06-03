package verbs;

import core.*;

public class Poke extends Verb {

    public Poke() {
        super("poke",
                new String[]{"touch", "prod", "tap", "feel"},
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                System.out.println("You poked the " + noun.getName());
                System.out.println("Good Job!");
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
