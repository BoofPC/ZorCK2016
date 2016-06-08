package areas;

import core.*;
import items.*;

/**
 * Tutorial area based on {@link Test01}.
 */
public class TutorialArea extends Area {

    public TutorialArea(final World containingWorld) {
        // Always have this
        super(containingWorld);
        // Portals leading east to Test2 and south to Test4 (the way to Test4 is blocked)
        this.portals().east(new Portal(Portal.State.UNLOCKED, Test02.class))
                .south(new Portal(Portal.State.LOCKED, Test04.class));
        // This is the title of the area; it appears every move for which the player is in the area
        this.title("Test Area 1")
        // This is the description of the area which appears when the player initially enters
            .initialDescription("This is the first test area, there is path to "
                + "the east and a locked door to the south. There is dark "
                + "and white chocolate on the ground")
        // This is the description of the area which appears when the player inputs LOOK
            .description("This is the first test area")
        // The way to the south is blocked by a door, named "Southern Door", which uses the Key item
        // as a key and is connected to the southern portal. Set Key to the class of the
        // corresponding key, or to null
            .item(new Door(true, "Southern Door", Key.class, this.portals().south()))
        // This room contains both dark and white chocolate
            .item(new DarkChocolate())
            .item(new WhiteChocolate());
    }

    // If you don't have any special interactions, you're done and don't need an interact.
    // To see how special interactions work, see Test8.
}
