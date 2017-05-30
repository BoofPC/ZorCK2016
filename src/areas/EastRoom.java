package areas;

import core.*;
import items.Door;
import items.Muffin;
import items.TreasureChest;
import verbs.Open;

/* This is the room where the player gets the muffin
 * and the key. This room is special, because there is
 * a box with stuff in it. */
public class EastRoom extends Area<NoState> {

    /* Keeps track of the first time the player opens the chest.
    *  This variable is not necessary to make rooms. Please see
    *  lampOnPreviously in CenterRoom for more information. */
    private boolean droppedKey;

    /* For more information about how rooms work, please
     * see CenterRoom. */
    public EastRoom(World containingWorld) {
        super(containingWorld);

        droppedKey = false;

        this.title("East Room")
                .articleThe(true)
                .description("This room is shaped like a cube. " +
                        "The walls, floor, and ceiling are all the " +
                        "exact same size. In the center of the room " +
                        "lies a small, cube-shaped treasure chest. " +
                        "There is a door to the west.")
                .shortDescription("There is a door to the west.")
                .item(new TreasureChest())
                .item(new Muffin())
                .item(new Door(false, "West Door", null, this.portals().west()));

        this.portals()
                .west(new Portal(Portal.State.UNLOCKED, CenterRoom.class));
    }

    /* The only special interaction in this room is when the Player opens
     * the Treasure Chest. When this happens, the item inside the box is
     * "dropped" into the room. See Center Room for more information about
     * writing the interact method for each room. */
    @Override
    public void interact(Command command, Context context) {
        /* When the Player opens the Treasure Chest, you need to
         * make the item inside appear in the room by making the
         * box "drop" the item. First, check to see if the player
         * opened the box. */
        if (command.getVerb().getClass().equals(Open.class)) {
            /* If they did, call the drop method on the Treasure
             * Chest Item. */
            this.getItem(TreasureChest.class).drop(this);
            /* Note that the Treasure Chest no longer has the
             * Key inside at this point. */

            /* If the player opened the chest for the first time... */
            if (!droppedKey) {
                /* Award them with 10 points. */
                context.getPlayer().addScore(10);
                droppedKey = true;
                System.out.println("A key falls out of the Treasure Chest.");
            }
        }
        super.interact(command, context);
    }
}
