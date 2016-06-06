package areas;

import core.*;
import items.*;

public class Hallway08 extends Area {

    public Hallway08(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, Hallway06.class))
            .south(new Portal(false, DuanesRoom.class))
            .west(new Portal(false, Hallway09.class))
            .east(new Portal(false, Hallway07.class));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
