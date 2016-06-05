package areas;

import core.*;
import items.*;

public class Test03 extends Area {
    public Test03(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .west(new Portal(false, "Test02"))
            .south(new Portal(false, "Test06"));
        this.title("Test Area 3")
            .initialDescription("This is the third test area, there is path "
                + "leading west and a path leading south. There is a sword "
                + "on the ground")
            .description("This is the third test area")
            .item(new Sword())
            .state("First", true);
    }
}
