package areas;

import core.*;
import items.*;

public class Hallway15 extends Area {
    public Hallway15(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, OishisRoom.class))
            .south(new Portal(false, GharstsRoom.class))
            .west(new Portal(false, Hallway16.class))
            .east(new Portal(false, Hallway14.class));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(false, "Northern Door", null, this.portals().north()))
            .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
