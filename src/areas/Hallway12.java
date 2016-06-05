package areas;

import core.*;
import items.*;

public class Hallway12 extends Area {
    public Hallway12(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(false, "Hallway13"))
            .south(new Portal(false, "RomanosRoom"))
            .west(new Portal(false, "Hallway14"))
            .east(new Portal(false, "Hallwa11"));
        this.title("Hallway")
            .initialDescription("----------").description("-----")

            .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
