package areas;

import core.*;
import items.*;

public class Hallway05 extends Area {

    public Hallway05(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, Hallway04.class))
            .south(new Portal(false, Hallway06.class))
            .west(new Portal(false, CompSciRoom.class))
            .east(new Portal(false, SecurityRoom.class));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)
                    
            .item(new Door(true, "Western Door", null, this.portals().west()))
            .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
