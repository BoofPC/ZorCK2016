package areas;

import core.*;
import items.*;

public class Test09 extends Area {
    public Test09(final World containingWorld) {
        super(containingWorld);
        this.portals().west(new Portal(false, Test08.class)).north(new Portal(false, Test06.class));
        this.title("Test Area 9")
            .initialDescription("This is the ninth test area, there is path "
                + "leading west and a path leading north. There is a "
                + "Hamburger on the ground.")
            .description("This is the ninth test area")
            .state("First", true)
            .item(new Hamburger());
    }
}
