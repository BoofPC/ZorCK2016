package areas;

import core.*;
import items.*;

public class Hallway11 extends Area {
    public Hallway11(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .south(new Portal(false, "BroadcastingRoom"))
            .west(new Portal(false, "Hallway12"))
            .east(new Portal(false, "Hallwa10"));
        this.title("Hallway")
            .initialDescription("----------").description("-----")

            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
