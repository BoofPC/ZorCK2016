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
            .description("----------").shortDescription("-----").articleThe(true)

            .item(new Door(true, "Library Door", Key.Library.class, this.portals().east()));
    }
}
