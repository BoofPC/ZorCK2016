package areas;

import core.*;
import items.*;

public class Hallway14 extends Area<NoState> {
    public Hallway14(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(true, StaffLounge.class)).west(new Portal(false, Hallway15.class))
                .east(new Portal(false, Hallway12.class));
        this.title("Hallway").description("----------").shortDescription("-----").articleThe(true)
                .item(new Door(true, "Southern Door", Key.StaffLounge.class, this.portals().south()));
    }
}
