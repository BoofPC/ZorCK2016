package verbs;

import core.*;

public class Take extends Verb {

    public Take() {
        super("take", Verb.usage().noun(), "get", "obtain", "pick up", "pickup", "steal");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Command.NounOrigin nounOrigin = command.getNounOrigin();
        final Player player = construct.getPlayer();

        switch (nounOrigin) {
            case AREA:
                switch (noun.usage().take()) {
                    case TAKABLE:
                        player.getCurrentArea().removeItem(noun);
                        player.addItem(noun);
                        System.out.println(player.getName() + " took the " + noun.name());
                        break;
                    case TOO_HEAVY:
                        System.out.println("The " + noun.name() + " is too heavy for that");
                        break;
                    case BOLTED_DOWN:
                        System.out.println("The " + noun.name() + " is bolted down");
                        break;
                    default:
                        System.out.println("You can't take the " + noun.name());
                        break;
                }
                break;
            default:
                System.out.println("You already have that.");
                break;
        }
    }
}
