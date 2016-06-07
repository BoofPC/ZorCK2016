package areas;

import core.*;
import items.*;

public class Hallway02 extends Area {

    public Hallway02(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, Hallway01.class))
            .south(new Portal(false, Hallway03.class))
            .west(new Portal(false, BoothsRoom.class))
            .east(new Portal(false, JorstadsRoom.class));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(false, "Western Door", null, this.portals().west()))
            .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
