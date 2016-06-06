package areas;

import core.*;
import items.*;

public class BroadcastingRoom extends Area {

    public BroadcastingRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway11.class))
                .east(new Portal(true, AdamsonsRoom.class));
        this.title("Broadcasting Room").initialDescription("----------").description("-----").articleThe(true)
                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new Door(true, "Eastern Door", "Adamson's Key", this.portals().east()));
    }
}
