package areas;

import core.*;
import items.*;

public class Test07 extends Area {
    public Test07(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .east(new Portal(false, Test08.class))
            .north(new Portal(false, Test04.class));
        this.title("Test Area 7")
            .description("This is the seventh test area, there is a "
                + "path to the east and to the north. There is a Lantern "
                + "on the ground")
            .shortDescription("This is the seventh test area").item(new Lantern())
            .state("First", true);
    }
}
