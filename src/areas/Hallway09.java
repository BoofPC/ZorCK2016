package areas;

import core.*;
import items.*;

public class Hallway09 extends Area {
    public Hallway09(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .south(new Portal(false, "ISSRoom"))
            .west(new Portal(false, "Hallway10"))
            .east(new Portal(false, "Hallway08"));
        this.title("Hallway")
            .initialDescription("----------").description("-----")

            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
