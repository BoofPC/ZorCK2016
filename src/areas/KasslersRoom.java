package areas;

import core.*;
import items.*;

public class KasslersRoom extends Area {

    public KasslersRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway16.class));
        this.title("Kassler's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
