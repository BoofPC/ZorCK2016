package areas;

import core.*;
import items.*;

public class Hallway16 extends Area {
    public Hallway16(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, SchuchartsRoom.class))
                .south(new Portal(false, KasslersRoom.class))
                .west(new Portal(false, Hallway17.class)).east(new Portal(false, Hallway15.class));
        this.title("Hallway").description("----------").shortDescription("-----").articleThe(true)

                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
