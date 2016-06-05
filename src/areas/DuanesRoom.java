package areas;

import core.*;
import items.*;

public class DuanesRoom extends Area {

    public DuanesRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, "Hallway08"));
        this.title("Duane's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
