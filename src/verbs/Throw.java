package verbs;

import core.Command;
import core.Context;
import core.Item;
import core.Player;
import core.Verb;

public class Throw extends Verb {
    public Throw() {
        super("throw", Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();

        switch (command.getNounOrigin()) {
            case PLAYER:
                switch (noun.usage().take()) {
                    case TAKABLE:
                        player.removeItem(noun);
                        player.getCurrentArea().item(noun);
                        System.out.println("You threw the " + noun.name() + ".");
                        System.out.println("Thunk.");
                        break;
                    default:
                        System.out.println("You can't bring yourself to do it.");
                        break;
                }
                break;
            default:
                System.out.println("You don't have the " + noun.name());
                break;
        }
    }
}
