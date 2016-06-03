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

        //TODO: add way to unlock portal by opening window
        this.getPortals().east(new Portal(Portal.State.LOCKED, "Roof"))
            .south(new Portal(Portal.State.UNLOCKED, "Hallway07"));

        this.setTitle("Women's Restroom");
        this.setInitialDescription("The room is dimly lit, illuminated only by the "
                + "light coming in from the window to the east. To the south "
                + "is a doorway leading into the hallway. A poster hangs on "
                + "the door of one of the stalls.");
        this.setDescription("This is the Women's Restroom.");

        this.setSound("You hear an incessant dripping sound coming from a faucet.");
        this.setSmell("It smells like flowers.");

        this.addItem(new AdamsonPoster());

    }

    @Override
    public void interact(final Command command, final Context context) {
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().getName();

        //read the poster, in case the player looks at it instead
        if (verb.equals("examine") && noun.equals("Adamson Poster")) {
            //prepare your eyes for the beautiful sight
            new Read().run(command, context);
        } else {
            if(command.getNoun() !=  null) {
                command.getNoun().interact(command,context);
            }
            if(!context.getSkipGeneral()) {
                command.getVerb().run(command, context);
            }
        }
    }

}
