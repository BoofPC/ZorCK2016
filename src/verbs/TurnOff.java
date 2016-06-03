package verbs;

import java.util.Arrays;

import core.*;

public class TurnOff extends Verb {

    public TurnOff() {
        super("turn off",
                Arrays.asList("deactivate"),
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
                if (noun.usage().active() == Item.Usage.Active.ON) {
                    noun.usage().active(Item.Usage.Active.OFF);
                    System.out.println("You turned off the " + noun.getName());
                } else if (noun.usage().active() == Item.Usage.Active.OFF) {
                    System.out.println(noun.getName() + " is already off");
                } else {
                    System.out.println("I don't see how you expect to do that");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
