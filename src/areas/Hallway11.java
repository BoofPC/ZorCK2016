package areas;

import core.*;
import items.*;

public class Hallway11 extends Area {
    public Hallway11(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, BroadcastingRoom.class))
                .west(new Portal(false, Hallway12.class)).east(new Portal(false, Hallway10.class));
        this.title("Hallway").description("------").shortDescription("-----").articleThe(true)

                .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
