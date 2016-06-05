package areas;

import core.*;
import items.*;

public class JorstadsRoom extends Area {

    public JorstadsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().west(new Portal(false, "Hallway02"));
        this.title("Jorstad's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Western Door", null, this.portals().west()));
    }
}
