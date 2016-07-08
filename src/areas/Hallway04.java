package areas;

import core.*;
import items.*;

public class Hallway04 extends Area<NoState> {

    public Hallway04(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway03.class))
                .south(new Portal(false, Hallway05.class))
                .west(new Portal(false, WilsonsRoom.class))
                .east(new Portal(false, StakersRoom.class));
//                .down(new Portal(false, Cafeteria.class));
        this.title("Hallway").description("The floor feels kind of shaky here...")
                .shortDescription("-----").articleThe(true)

                .item(new Door(true, "Western Door", null, this.portals().west()))
                .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
