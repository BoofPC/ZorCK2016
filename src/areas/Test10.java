package areas;

import core.*;

public class Test10 extends Area {
    public Test10(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .north(new Portal(false, "Test08"));
        this.title("Test Area 10")
            .initialDescription("This is the tenth test area. You are in a "
                + "cave! There is exit to the north")
            .description("This is the tenth test area")
            .state("First", true)
            .dark(true);
    }
}
