package areas;

import core.*;
import items.*;

public class Hallway15 extends Area {
    public Hallway15(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "OishisRoom"))
            .south(new Portal(false, "GharstsRoom"))
            .west(new Portal(false, "Hallway16"))
            .east(new Portal(false, "Hallwa14"));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(false, "Northern Door", null, this.portals().north()))
            .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
