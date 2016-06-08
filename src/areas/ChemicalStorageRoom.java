package areas;

import core.*;
import items.*;

public class ChemicalStorageRoom extends Area {

    public ChemicalStorageRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, BirkenfeldsRoom.class));
        this.title("Chemical Storage Room").description("You're in the Chemical Storage room. This room smells weird. You feel light headed.").shortDescription("You're in the Chemical Storage room. You feel light headed.").articleThe(true)
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}