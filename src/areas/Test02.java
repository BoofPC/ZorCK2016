package areas;

import core.*;
import items.*;

public class Test02 extends Area {
    public Test02(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .west(new Portal(false, "Test01"))
            .east(new Portal(false, "Test03"))
            .south(new Portal(false, "Test05"));
        this.title("Test Area 2")
            .initialDescription("This is the second test area, there is path "
                + "leading east-west and a door to the south. There is a "
                + "screwdriver on the ground")
            .description("This is the second test area")
            .item(new Door(false, "Southern Door", "Key", this.portals().south()))
            .item(new Screwdriver())
            .state("First", true);
    }
}
