package areas;

import core.Area;
import core.NoState;
import core.World;

/* This is where the player starts. The player starts here because of Line 54
 * in the Game class. What's special about this room is that it starts out
 * DARK, which means that the player can't do anything until they turn the
 * lights on. */
public class CenterRoom extends Area<NoState> {

    /* This is where you specify the room information, like its title
     * (Center Room), a description of what it looks like, and a shortened
     * description. You can also specify it the room */
    public CenterRoom(World containingWorld) {
        super(containingWorld);
    }
}
