package areas;

import core.*;
import items.*;

public class Hallway17 extends Area {
    public Hallway17(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, FishersRoom.class))
            .east(new Portal(false, Hallway16.class));
        this.title("Hallway")
            .description("----------").shortDescription("-----").articleThe(true)

            .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
