package verbs;

import core.*;

/**
 * A note about Give: The inputs "Give item to Booth" and "Give item" are syntactically identical
 * Because of the simplicity of our parser, you should only have one item which can receive in any
 * room at any time, or else the player cannot choose which item to give to
 */
public class Give extends Verb {

    public Give() {
        super("give", Verb.usage().noun(), "gift");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Command.NounOrigin nounOrigin = command.getNounOrigin();
        final Player player = construct.getPlayer();

        switch (nounOrigin) {
            case PLAYER:
                Item receiver = null;
                for (final Item item : player.getCurrentArea().items()) {
                    if (item.usage().recieve() == Item.RECIEVE) {
                        receiver = item;
                        break;
                    }
                }
                if (receiver != null) {
                    receiver.receive(noun);
                    player.removeItem(noun);
                    System.out.println("You gave the " + noun.name() + " to " + receiver.name());
                } else {
                    System.out.println("I don't see who you'd want to give that to");
                }
                break;
            default:
                System.out.println("You don't even have a " + noun.name());
                break;
        }
    }
}
