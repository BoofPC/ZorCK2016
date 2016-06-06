package areas;

import core.*;
import items.*;

public class BoothsRoom extends Area {

    public BoothsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().east(new Portal(false, Hallway02.class));
        this.title("Booth's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
