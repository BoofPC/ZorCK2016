package areas;

import core.*;
import items.*;

public class AdamsonsRoom extends Area {

    public AdamsonsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway10.class))
                .west(new Portal(true,BroadcastingRoom.class));
        this.title("Adamson's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new Door(true, "Western Door", "Adamson's Key", this.portals().west()));
    }
}
