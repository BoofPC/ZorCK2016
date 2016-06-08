package areas;

import core.*;
import items.*;

public class Test04 extends Area {
    public Test04(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .north(new Portal(true, Test01.class))
            .east(new Portal(false, Test05.class))
            .south(new Portal(false, Test07.class));
        this.title("Test Area 4")
            .initialDescription("This is the fourth test area, there are paths"
                + " to the east and south and a locked door to the north.")
            .description("This is the fourth test area")
            .item(new Door(true, "Northern Door", Key.class, this.portals().north()))
            .state("First", true);
    }
}
