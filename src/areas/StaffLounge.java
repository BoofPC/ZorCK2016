package areas;

import core.*;
import items.*;

public class StaffLounge extends Area {

    public StaffLounge(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(true, Hallway14.class));
        this.title("Staff Lounge").description("----------").shortDescription("-----").articleThe(true)
                .item(new Door(true, "Northern Door", KeyStaffLounge.class, this.portals().north()));
    }
}
