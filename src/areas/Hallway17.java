package areas;

import core.*;
import items.*;

public class Hallway17 extends Area {
    public Hallway17(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "FishersRoom"))
            .east(new Portal(false, "Hallwa16"));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
