package areas;

import core.*;
import items.*;

public class Hallway13 extends Area {
    public Hallway13(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .south(new Portal(false, "Hallway12"))
            .east(new Portal(true, "Library")); //Door to the library is locked
        this.title("Hallway")
            .initialDescription("----------").description("-----")

            .item(new Door(true, "Library Door", "Library Key", this.portals().east()));
    }
}
