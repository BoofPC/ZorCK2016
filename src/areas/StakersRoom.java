package areas;

import core.*;
import items.*;

public class StakersRoom extends Area {

    public StakersRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().west(new Portal(false, "Hallway04"));
        this.title("Staker's Room").initialDescription("----------").description("-----")
                .item(new Door(false, "Western Door", null, this.portals().west()));
    }
}
