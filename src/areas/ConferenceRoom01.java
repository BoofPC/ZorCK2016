package areas;

import core.*;
import items.*;

public class ConferenceRoom01 extends Area {

    public ConferenceRoom01(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Library.class));
        this.title("Conference Room 1").initialDescription("----------").description("-----")
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
}
