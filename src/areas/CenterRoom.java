package areas;

import core.*;
import items.Door;
import items.Key;
import items.Lamp;
import items.Scissors;
import verbs.Unlock;

/* This is where the player starts. The player starts here because of Line 54
 * in the Game class. What's special about this room is that it starts out
 * DARK, which means that the player can't see anything until they turn the
 * lights on. */
public class CenterRoom extends Area<NoState> {
    /* This is true if the Lamp has been turned on for the first time.
    *  Don't mind this part - you don't have to include this in the rooms
    *  that you make. However, this is a way to keep track of when a player
    *  achieves something for the first time so that you can award them with
    *  points. */
    private boolean lampOnPreviously;

    /* This is where you specify the room information, like its title
     * (Center Room), a description of what it looks like, and a shortened
     * description. You can also specify it the room */
    public CenterRoom(World containingWorld) {
        super(containingWorld);

        lampOnPreviously = false;

        /* This is printed every time the user walks in the room.
        *  This is how they know what room they are in! */
        this.title("Center Room")
                /* If you want the room to be read "The [title]" */
                .articleThe(true)
                /* This is read only the first time someone walks
                 * in the room OR if they look around the room.
                 * Be sure to include the location of all of the doors.*/
                .description("This room is very large. The sound of your breathing " +
                        "echoes off the walls. There is a door to the north and " +
                        "a door to the east.")
                /* This description is read every time after the first.
                 * Make it brief! Include door locations! */
                .shortDescription("There is a door to the north and a door " +
                        "to the east.")
                /* This is how you add items to the room. */
                .item(new Lamp())
                .item(new Scissors())
                /* This is a Door. The constructor takes four parameters:
                * (boolean) if the door is locked, (String) name of the door,
                * (class) name of Key that unlocks door or null if not applicable,
                * (portal) the portal associated with the door. */
                .item(new Door(true, "North Door", Key.NorthDoor.class, this.portals().north()))
                /* An unlocked door. */
                .item(new Door(false, "East Door", null, this.portals().east()));

        /* This is how you add portals, which are what link rooms together
         * when the player travels in a given direction. */
        this.portals()
                .north(new Portal(Portal.State.LOCKED, NorthRoom.class))
                .east(new Portal(Portal.State.UNLOCKED, EastRoom.class));
    }

    /* This runs whenever the Player does something within this room. If there are any special interactions
     * (e.g. a lamp that determines whether or not the room is dark), then you must specify what happens here.
      * You can check to see what verb the Player used by checking the Command, and you can get Player and World
      * information from Context. The final line of this method must always say super.interact(command, context)
      *
      * IMPORTANT: You have to write out a special interaction for unlocking doors. Because the Unlock verb doesn't
      * work correctly, this is how you have to deal with locked doors. */
    @Override
    public void interact(Command command, Context context) {
        /* If the lamp is turned on... */
        if (this.getItem(Lamp.class).active()) {
            /* And this is the first time that the lights have been turned on... */
            if (!lampOnPreviously) {
                lampOnPreviously = true;
                /* Award 10 points to the player, and... */
                context.getPlayer().addScore(10);
            }
            /* The room is no longer dark */
            this.dark(false);
        } else {
            /* Make/Keep the room dark */
            this.dark(true);
        }

        /* HOW TO UNLOCK A DOOR
        *  If the player wants to unlock a door...
        * */
        if (command.getVerb().getClass().equals(Unlock.class)) {
            /* Assume they are talking about the North Door and
            *  try to unlock it, if they have the key.*/
            if (context.getPlayer().hasItem(Key.NorthDoor.class)) {
                /* Unlock the portal */
                this.portals().north().unlock();
            }
        }
        super.interact(command, context);
    }
}
