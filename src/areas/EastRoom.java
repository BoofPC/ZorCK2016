package areas;

import core.Area;
import core.NoState;
import core.World;

/* This is the room where the player gets the muffin
 * and the key. This room is special, because there is
 * a box with stuff in it. */
public class EastRoom extends Area<NoState> {

    /* This is where you specify the room information, like its title
     * (North Room), a description of what it looks like, and a shortened
     * description. You can also specify it the room */
    public EastRoom(World containingWorld) {
        super(containingWorld);
    }
}
