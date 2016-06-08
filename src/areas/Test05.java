package areas;

import core.*;
import items.*;

public class Test05 extends Area {
    public Test05(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .north(new Portal(false, Test02.class))
            .west(new Portal(false, Test04.class))
            .east(new Portal(false, Test06.class))
            .south(new Portal(false, Test08.class));
        this.title("Test Area 5")
            .initialDescription("This is the fifth test area, there is path "
                + "leading east-west, a door to the north, and a path to " + "the south.")
            .description("This is the fifth test area")
            .item(new Door(false, "Northern Door", Key.class, this.portals().north()))
            .state("First", true);
    }
}
