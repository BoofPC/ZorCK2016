package areas;

import core.*;
import items.*;

public class JanitorsCloset extends Area {

    public JanitorsCloset(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(Portal.State.UNLOCKED, Hallway17.class));
        this.title("Janitor's Closet")
                .description("A dark old Janitor's Closet. The room is oddly humid... "
                        + "You see a pair of plastic sissors on the floor.")
                .shortDescription(
                        "This is the Janitor's Closet you see extraordinarily sharp scissors and a small planter with grass."
                                + "There is a door leaving where you entered to the east")
                .item(new Scissors()).item(new Grass());
    }

}

