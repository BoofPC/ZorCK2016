package areas;

import core.*;
import items.*;

public class Hallway14 extends Area {
    public Hallway14(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "MensRestroom"))
            .south(new Portal(true, "StaffLounge"))
            .west(new Portal(false, "Hallway15"))
            .east(new Portal(false, "Hallwa12"));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(false, "Northern Door", null, this.portals().north()))
            .item(new Door(true, "Southern Door", "Staff Lounge Key", this.portals().south()));
    }
}
