package areas;

import core.*;
import items.*;

public class Test01 extends Area {
    public Test01(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .east(new Portal(false, "Test02"))
            .south(new Portal(true, "Test04"));
        this.title("Test Area 1")
            .initialDescription("This is the first test area, there is path to "
                + "the east and a locked door to the south. There is dark "
                + "and white chocolate on the ground")
            .description("This is the first test area")
            .item(new Door(true, "Southern Door", "Key", this.portals().south()))
            .item(new DarkChocolate())
            .item(new WhiteChocolate())
            .state("First", true);
    }
}
