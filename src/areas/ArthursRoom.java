package areas;

import core.*;
import items.*;

public class ArthursRoom extends Area {

    public ArthursRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().west(new Portal(false, Hallway03.class));
        this.title("Arthur's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Western Door", null, this.portals().west()));
    }
}
