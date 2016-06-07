package areas;

import core.*;
import items.*;

public class Hallway03 extends Area {

    public Hallway03(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, Hallway02.class))
            .south(new Portal(false, Hallway04.class))
            .west(new Portal(true, SecretPassage.class))
            .east(new Portal(false, ArthursRoom.class));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(true, "Western Door", "Key to Secret Passage", this.portals().west()))
            .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
