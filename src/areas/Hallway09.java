package areas;

import core.*;
import items.*;

public class Hallway09 extends Area {
    public Hallway09(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .south(new Portal(false, ISSRoom.class))
            .west(new Portal(false, Hallway10.class))
            .east(new Portal(false, Hallway08.class));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
