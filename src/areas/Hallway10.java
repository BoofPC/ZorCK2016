package areas;

import core.*;
import items.*;

public class Hallway10 extends Area {
    public Hallway10(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, KUGRRoom.class))
            .south(new Portal(false, AdamsonsRoom.class))
            .west(new Portal(false, Hallway11.class))
            .east(new Portal(false, Hallway09.class));
        this.title("Hallway")
            .description("----------").shortDescription("-----").articleThe(true)

            .item(new Door(true, "Northern Door", null, this.portals().north()))
            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
