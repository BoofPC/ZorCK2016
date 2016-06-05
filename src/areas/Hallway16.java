package areas;

import core.*;
import items.*;

public class Hallway16 extends Area {
    public Hallway16(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "SchuchartsRoom"))
            .south(new Portal(false, "KasslersRoom"))
            .west(new Portal(false, "Hallway17"))
            .east(new Portal(false, "Hallwa15"));
        this.title("Hallway")
            .initialDescription("----------").description("-----")

            .item(new Door(false, "Northern Door", null, this.portals().north()))
            .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
