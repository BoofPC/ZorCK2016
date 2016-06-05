package areas;

import core.*;
import items.*;

public class Hallway08 extends Area {

    public Hallway08(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "Hallway06"))
            .south(new Portal(false, "DuanesRoom"))
            .west(new Portal(false, "Hallway09"))
            .east(new Portal(false, "Hallway07"));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
