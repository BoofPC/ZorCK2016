package areas;

import core.*;
import items.*;

public class ChemicalStorageRoom extends Area {

    public ChemicalStorageRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, BirkenfeldsRoom.class));
        this.title("Chemical Storage Room").initialDescription("----------").description("-----").articleThe(true)
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
