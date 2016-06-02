package verbs;

import core.*;

/**
 *
 * @author Alex Johnson & Samantha
 */
public class Drop extends Verb {

    public Drop() {
        super("drop",
                new String[]{"release", "throw out", "toss", "leave"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {
        Item noun = command.getNoun();

        Player player = construct.getPlayer();

        if (player.hasMatching(noun)) {
            if (noun.getUsageKey(1) == 1) {
                player.removeItem(noun);
                player.getCurrentArea().addItem(noun);
                System.out.println("You dropped " + noun.getName());
            } else {
                System.out.println("I'm sorry " + player.getName()
                        + ", I can't allow you to do that");
            }
        } else {
            System.out.println("You don't have the " + noun.getName());
        }
    }
}
