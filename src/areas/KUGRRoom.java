package areas;

import core.*;
import items.*;

public class KUGRRoom extends Area {

    public KUGRRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, Hallway10.class));
        this.title("KUGR Room").initialDescription("----------").description("-----").articleThe(true)
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
