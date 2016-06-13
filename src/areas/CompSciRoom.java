package areas;

import core.*;
import items.*;
import verbs.*;

public class CompSciRoom extends Area {

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(Portal.State.UNLOCKED, Hallway05.class))
                .south(new Portal(Portal.State.LOCKED, WatchmansRoom.class));
        this.title("Comp. Sci. Room").articleThe(true)
                .description("The room is dark. Only the light shining through "
                        + "cracks in the roof light the room.\n"
                        + "Old computers lie on dust-covered tabletops.\n"
                        + "To the east is a door leading to the hallway, and "
                        + "to the south is a door leading to Ms. Watchmans' "
                        + "Room.")
                .shortDescription("You are in the Comp. Sci. Lab.")
                .item(new BloodyNote())
                .item(new BrokenComputers());
    }
    
    @Override
    public void interact(Command command, Context context) {
        final Verb verb = command.getVerb();
        final Item noun = command.getNoun();
        final Player player = context. getPlayer();
        
        if (verb.getClass().equals(Smell.class)) {
            player.addScore(10);
            verb.run(command, context);
        } else {
            super.interact(command, context);
        }
    }

}
