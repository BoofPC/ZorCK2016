package verbs;

import core.*;

public class Put extends Verb {

    public Put() {
        super("put", Verb.usage().noun(), "place", "set");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Command.NounOrigin nounOrigin = command.getNounOrigin();
        final Player player = construct.getPlayer();

        switch (nounOrigin) {
            case PLAYER:
                switch (noun.usage().puttable()) {
                    case PUTTABLE:
                        player.removeItem(noun);
                        player.getCurrentArea().item(noun);
                        System.out.println("You put " + noun.name() + " in " + player.getCurrentArea());
                        break;
                    default:
                        System.out.println("I'm sorry " + player.getName() + ", I can't allow you to do that");
                        break;
                }
                break;
            default:
                System.out.println("You don't have the " + noun.name());
                break;
        }
    }
}
