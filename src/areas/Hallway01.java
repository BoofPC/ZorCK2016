package areas;

import core.*;
import items.*;

public class Hallway01 extends Area {

    public Hallway01(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, RosenquistsRoom.class))
            .south(new Portal(false, Hallway02.class))
            .west(new Portal(false, HendrichsonsRoom.class))
            .northwest(new Portal(false, BirkenfeldsRoom.class));
        this.title("Hallway")
            .description("----------").shortDescription("-----").articleThe(true)

            .item(new Door(false, "Northern Door", null, this.portals().north()))
            .item(new Door(false, "Western Door", null, this.portals().west()))
            .item(new Door(false, "Northwestern Door", null, this.portals().northwest()));
    }
}
