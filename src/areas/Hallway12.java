package areas;

import core.*;
import items.*;

public class Hallway12 extends Area<NoState> {
    public Hallway12(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway13.class))
                .south(new Portal(false, RomarosRoom.class))
                .west(new Portal(false, Hallway14.class)).east(new Portal(false, Hallway11.class));
        this.title("Hallway").description("----------").shortDescription("-----").articleThe(true)

                .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
