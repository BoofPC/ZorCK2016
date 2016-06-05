package areas;

import core.*;
import items.*;

public class BirkenfeldsRoom extends Area {

    public BirkenfeldsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().southeast(new Portal(false, "Hallwa01"))
                .north(new Portal(true, "ChemicalStorageRoom"));
        this.title("Birkenfeld's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Southeastern Door", null, this.portals().southeast()))
                .item(new Door(true, "Northern Door", null, this.portals().north()));
    }
}
