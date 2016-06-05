package areas;

import core.*;
import items.*;

public class Test05 extends Area {
    public Test05(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .north(new Portal(false, "Test02"))
            .west(new Portal(false, "Test04"))
            .east(new Portal(false, "Test06"))
            .south(new Portal(false, "Test08"));
        this.title("Test Area 5")
            .initialDescription("This is the fifth test area, there is path "
                + "leading east-west, a door to the north, and a path to " + "the south.")
            .description("This is the fifth test area")
            .item(new Door(false, "Northern Door", "Key", this.portals().north()))
            .state("First", true);
    }
}
