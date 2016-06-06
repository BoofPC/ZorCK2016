package areas;

import core.*;
import items.*;

public class Hallway13 extends Area {
    public Hallway13(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .south(new Portal(false, Hallway12.class))
            .east(new Portal(true, Library.class)); //Door to the library is locked
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(true, "Library Door", "Library Key", this.portals().east()));
    }
}
