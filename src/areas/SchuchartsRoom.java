package areas;

import core.*;
import items.*;

public class SchuchartsRoom extends Area {

    public SchuchartsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, Hallway16.class));
        this.title("Schuchart's Room").description("----------").shortDescription("-----")
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
