package areas;

import core.*;
import items.*;
import verbs.*;

public class CompSciRoom extends Area<NoState> {

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(Portal.State.UNLOCKED, Hallway05.class));
        this.title("Comp. Sci. Room").articleThe(true)
                .description("The room is dark. Only the light in the \n"
                        + "room comes from a flickering ceiling light.\n"
                        + "Old, run down, computers rest peacefully on \n"
                        + "dust covered tables throughout the room.\n"
                        + "On the floor is a note covered in blood.\n"
                        + "To the east is a door leading to the hallway.")
                .shortDescription("You are in the Comp. Sci. Lab.").item(new BloodyNote())
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
