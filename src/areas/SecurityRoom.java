package areas;

import core.*;
import items.*;

public class SecurityRoom extends Area {

    public SecurityRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().west(new Portal(false, Hallway05.class));
        this.title("Security Room").initialDescription("----------").description("-----").articleThe(true)
                .item(new Door(false, "Western Door", null, this.portals().west()));
    }
}
