package areas;

import core.*;
import items.*;
import verbs.Read;

/**
 * This area has a window that leads to the roof. There's nothing else here,
 * except for a poster on the door of a stall.
 */
public class WomensRestroom extends Area {

    public WomensRestroom(final World containingWorld) {
        super(containingWorld);

        //TODO: unlock window with key
        this.portals().east(new Portal(Portal.State.LOCKED, Roof.class))
            .south(new Portal(Portal.State.UNLOCKED, Hallway07.class));

        this.title("Women's Restroom")
            .description("The room is dimly lit, illuminated only by the "
                + "light coming in from the window to the east. To the south "
                + "is a doorway leading into the hallway. A poster hangs on "
                + "the door of one of the stalls.")
            .shortDescription("This is the Women's Restroom.").articleThe(true)

            .sound("You hear an incessant dripping sound coming from a faucet.")
            .smell("It smells like flowers.")

            .item(new AdamsonPoster());

    }

    @Override
    public void interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final Item noun = command.getNoun();

        //read the poster, in case the player looks at it instead
        if (verb.equals("examine") && noun.equals("Adamson Poster")) {
            //prepare your eyes for the beautiful sight
            new Read().run(command, context);
        }
        super.interact(command, context);
    }

}
