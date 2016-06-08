package areas;

import core.*;
import items.*;

public class ISSRoom extends Area {

    public ISSRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway09.class));
        this.title("ISS Room").description("----------").shortDescription("-----").articleThe(true)
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
