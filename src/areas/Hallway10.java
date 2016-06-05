package areas;

import core.*;
import items.*;

public class Hallway10 extends Area {
    public Hallway10(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "KUGRRoom"))
            .south(new Portal(false, "AdamsonsRoom"))
            .west(new Portal(false, "Hallway11"))
            .east(new Portal(false, "Hallway09"));
        this.title("Hallway")
            .initialDescription("----------").description("-----")

            .item(new Door(true, "Northern Door", null, this.portals().north()))
            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
