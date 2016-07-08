package areas;

import core.*;
import items.*;
import verbs.*;

public class CompSciRoom extends Area<NoState> {

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(Portal.State.UNLOCKED, Hallway05.class))
                .south(new Portal(Portal.State.LOCKED, WatchmansRoom.class));
        this.title("Comp Sci Room").articleThe(true)
                .description("")
                .shortDescription("").item(new BloodyNote())
                .item(new BrokenComputers());
    }

    @Override
    public void interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final Player player = context.getPlayer();

        if (verb.getClass().equals(Smell.class)) {
            player.addScore(10);
            verb.run(command, context);
        } else {
            super.interact(command, context);
        }
    }

}
