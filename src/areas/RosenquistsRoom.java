package areas;

import core.*;
import items.*;

public class RosenquistsRoom extends Area {

    public RosenquistsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, Hallway01.class));
        this.title("Rosenquist's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
