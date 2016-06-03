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
            receiver = player.getCurrentArea().getItems().stream()
                    .filter(i -> i.getUsageKey(14) == 2).findAny().orElse(null);
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
