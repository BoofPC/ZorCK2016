package areas;

import core.*;
import items.*;

public class StakersRoom extends Area<NoState> {

    public StakersRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().west(new Portal(false, Hallway04.class));
        this.title("Staker's Room").description("----------").shortDescription("-----")
                .item(new Door(false, "Western Door", null, this.portals().west()));
    }
}
