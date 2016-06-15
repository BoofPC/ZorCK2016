package areas;

import core.*;
import items.*;
import verbs.Read;

/**
 * This area has a window that leads to the roof. You unlock the window by using a key found by
 * using the plunger, which the girl in the stall gives you in exchange for toilet paper, on the
 * clogged toilet.
 */
public class WomensRestroom extends Area<NoState> {

    public WomensRestroom(final World containingWorld) {
        super(containingWorld);

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

                .item(new AdamsonPoster()).item(new CloggedToilet())
                .item(new Window(true, null, Key.RestroomWindow.class, this.portals().east()));

    }

    @Override
    public void interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final Item noun = command.getNoun();
        final Player player = context.getPlayer();

        //read the poster, in case the player looks at it instead
        if (verb.getTitle().equals("examine") && noun.equals("Adamson Poster")) {
            //prepare your eyes for the beautiful sight
            new Read().run(command, context);
        } else if (verb.getTitle().equals("unlock") && player.hasItem(Key.RestroomWindow.class)) {
            System.out.println(
                    "You twist the key and the lock on the windowmakes an audible 'click'.");
            this.portals().east().unlock();
            verb.run(command, context);
        } else if (verb.getTitle().equals("plunge")) {
            noun.interact(command, context);
        } else {
            super.interact(command, context);
        }
    }

}
