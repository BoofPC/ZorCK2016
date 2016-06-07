package areas;

import core.*;
import items.*;

public class Test06 extends Area {
    public Test06(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .north(new Portal(false, Test03.class))
            .west(new Portal(false, Test05.class))
            .south(new Portal(false, Test09.class));
        this.title("Test Area 6")
            .initialDescription("This is the sixth test area, there is path "
                + "leading west and a path leading north-south. There is "
                + "a key on the ground")
            .description("This is the sixth test area")
            .item(new Key())
            .state("First", true);
    }
}
