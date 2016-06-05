package areas;

import core.*;
import items.*;

public class OishisRoom extends Area {

    public OishisRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, "Hallway15"));
        this.title("Oishi's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
