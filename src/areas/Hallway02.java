package areas;

import core.*;
import items.*;

public class Hallway02 extends Area {

    public Hallway02(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "Hallway01"))
            .south(new Portal(false, "Hallway03"))
            .west(new Portal(false, "BoothsRoom"))
            .east(new Portal(false, "JorstadsRoom"));
        this.title("Hallway")
            .initialDescription("----------").description("-----").articleThe(true)

            .item(new Door(false, "Western Door", null, this.portals().west()))
            .item(new Door(false, "Eastern Door", null, this.portals().east()));
    }
}
