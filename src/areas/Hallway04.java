package areas;

import core.*;
import items.*;

public class Hallway04 extends Area<NoState> {

    public Hallway04(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway03.class))
                .south(new Portal(false, Hallway05.class));
        this.title("Hallway").description("the floor feels kind of shaky here...")
                .shortDescription("-----").articleThe(true);
    }
}
