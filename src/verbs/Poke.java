package verbs;

import core.*;

/**
 *
 * @author Alex Johnson
 */
public class Poke extends Verb {

    public Poke() {
        super("poke",
                new String[]{"touch", "prod", "tap", "feel"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {
        int direction = command.getDirection();
        Item noun = command.getNoun();

        Player player = construct.getPlayer();
        World world = construct.getWorld();

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
