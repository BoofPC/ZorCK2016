package areas;

import core.*;
import items.*;

public class RomarosRoom extends Area<NoState> {

    public RomarosRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway12.class));
        this.title("Romaro's Room").description("----------").shortDescription("-----")
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
