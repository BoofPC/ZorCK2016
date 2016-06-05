package areas;

import core.*;
import items.*;

public class Hallway06 extends Area {

    public Hallway06(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "Hallway05"))
            .south(new Portal(false, "Hallway08"))
            .west(new Portal(false, "WatchmansRoom"));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(true, "Western Door", null, this.portals().west()));
    }
}
