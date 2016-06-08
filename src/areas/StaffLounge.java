package areas;

import core.*;
import items.*;

public class StaffLounge extends Area {

    public StaffLounge(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(true, Hallway14.class));
        this.title("Staff Lounge").description("There is an old beat up "
                + "couch in front of the windows  with a spectacular view of Dyes"
                + " Inlet and a very old vending machine in the corner of the"
                + " room.\nOn the wall  near the door there is a loud refrigerator,"
                + " a sink and an old microwave. There is a door to the north.")
                .shortDescription("There is a couch.").articleThe(true)
                .smell("Smells like something is in the microwave.")
                .sound("You hear nothing over the annoying sound of the refrigerator.")
                .item(new Microwave())
                .item(new Refrigerator())
                .item(new VendingMachine())
                .item(new Door(true, "Northern Door", KeyStaffLounge.class,
                        this.portals().north()));
    }

}
