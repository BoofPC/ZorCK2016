package areas;

import core.Area;
import core.NoState;
import core.World;

/* This is the final room of the game. This is where
 * the troll is. This is the room that handles the
 * Give verb interaction between the player and the
 * troll. This is also the room where the player can
 * win the game. */
public class NorthRoom extends Area<NoState> {

    /* This is where you specify the room information, like its title
     * (North Room), a description of what it looks like, and a shortened
     * description. You can also specify it the room */
    public NorthRoom(World containingWorld) {
        super(containingWorld);
    }
}
