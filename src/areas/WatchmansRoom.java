package areas;

import core.*;
import items.*;

public class WatchmansRoom extends Area {

    public WatchmansRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().east(new Portal(false, Hallway06.class))
                .north(new Portal(false, CompSciRoom.class));
        this.title("Watchman's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Eastern Door", null, this.portals().east()))
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
