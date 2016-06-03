package verbs;

import core.*;

/**
 * A note about Give:
 * The inputs "Give item to Booth" and "Give item" are syntactically identical
 * Because of the simplicity of our parser, you should only have one item
 * which can receive in any room at any time, or else the player cannot choose
 * which item to give to
 */
public class Give extends Verb {

    public Give() {
        super("give",
                new String[]{"gift"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {
        Item noun = command.getNoun();

        Player player = construct.getPlayer();

        if (player.hasMatching(noun)) {
            Item receiver;
            receiver = null;
            for (int i = 0; i < player.getCurrentArea().getItems().size(); i++) {
                if (player.getCurrentArea().getItems().get(i).getUsageKey(14) == 2) {
                    receiver = player.getCurrentArea().getItems().get(i);
                    break;
                }
            }
            if (receiver != null) {
                receiver.receive(noun);
                player.removeItem(noun);
                System.out.println("You gave the " + noun.getName() + " to "
                        + receiver.getName());
            } else {
                System.out.println("I don't see who you'd want to give that to");
            }
        } else {
            System.out.println("You don't even have a " + noun.getName());
        }
    }
}
