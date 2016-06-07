package areas;

import core.*;
import items.*;

public class WilsonsRoom extends Area {

    public WilsonsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().east(new Portal(false, Hallway04.class));
        this.title("Wilson's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
