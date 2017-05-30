package areas;

import core.*;
import items.Door;
import items.Muffin;
import items.Troll;
import verbs.Give;

/* This is the final room of the game. This is where
 * the troll is. This is the room that handles the
 * Give verb interaction between the player and the
 * troll. This is also the room where the player can
 * win the game. */
public class NorthRoom extends Area<NoState> {

    /* For more information about how rooms work, please
     * see CenterRoom. */
    public NorthRoom(World containingWorld) {
        super(containingWorld);

        this.title("North Room")
                .articleThe(true)
                .description("This room is dimly lit. You can only make " +
                        "out the glowing yellow eyes of a troll. It looks " +
                        "very hungry! There is a door to the south.")
                .shortDescription("There is a door to the south.")
                .item(new Troll())
                .item(new Door(false, "South Door", null, this.portals().south()));

        this.portals()
                .south(new Portal(Portal.State.UNLOCKED, CenterRoom.class));
    }

    /* A working example of Give. I kind of cheated here, because there isn't a thing
    *  that is receiving an item, but I think that this is an acceptable workaround for
    *  now. */
    @Override
    public void interact(Command command, Context context) {
        /* If the Player doesn't have a muffin in their inventory...*/
        if (!context.getPlayer().hasItem(Muffin.class)) {
            System.out.println("The troll is craving a muffin. It decides to eat you, instead!");
            context.getPlayer().setDeath(Game.Status.DIE);
            return;
        }

        /* If the Player mentions giving a muffin... */
        if (command.getVerb().getClass().equals(Give.class)
                && command.getNoun().getClass().equals(Muffin.class)) {
            /* Take the muffin out of their inventory... */
            context.getPlayer().removeItem(context.getPlayer().getItem(Muffin.class));
            System.out.println("You gave the troll the muffin. It looks happy.");
            /* Award the Player with 10 points... */
            context.getPlayer().addScore(10);
            /* And make them win the game. */
            context.getPlayer().setDeath(Game.Status.WIN);
        }
        super.interact(command, context);
    }
}
