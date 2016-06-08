package areas;

import core.*;
import items.*;

public class GharstsRoom extends Area {

    public GharstsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway15.class));
        this.title("Gharst's Room").description("----------").shortDescription("-----")
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
