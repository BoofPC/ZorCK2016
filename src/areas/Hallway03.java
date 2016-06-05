package areas;

import core.*;
import items.*;

public class Hallway03 extends Area {

    public Hallway03(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "Hallway02"))
            .south(new Portal(false, "Hallway04"))
            .west(new Portal(true, "SecretPassage"))
            .east(new Portal(false, "ArthursRoom"));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(true, "Western Door", "Key to Secret Passage", this.portals().west()))
            .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
