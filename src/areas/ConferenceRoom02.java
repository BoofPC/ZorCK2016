package areas;

import core.*;
import items.*;

public class ConferenceRoom02 extends Area<NoState> {

    public ConferenceRoom02(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, Library.class));
        this.title("Conference Room 2").description("----------").shortDescription("-----")
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }
}
