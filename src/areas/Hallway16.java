package areas;

import core.*;
import items.*;

public class Hallway16 extends Area<NoState> {
    public Hallway16(final World containingWorld) {
        super(containingWorld);

        this.portals().west(new Portal(false, Hallway17.class)).east(new Portal(false, Hallway15.class));
        this.title("Hallway").description("----------").shortDescription("-----").articleThe(true);

    }
}
