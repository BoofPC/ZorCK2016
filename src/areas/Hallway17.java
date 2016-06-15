package areas;

import core.*;
import items.*;

public class Hallway17 extends Area<NoState> {
    public Hallway17(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, FishersRoom.class))
                .east(new Portal(false, Hallway16.class))
                .west(new Portal(false, JanitorsCloset.class));
        this.title("Hallway... You see a dark room to the west. A shiny watch lies on the ground.")
                .description("----------").shortDescription("-----").articleThe(true)
                .item(new Rolex())
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
