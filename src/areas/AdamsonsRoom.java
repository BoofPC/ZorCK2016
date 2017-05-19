package areas;

import core.*;
import items.*;

public class AdamsonsRoom extends Area<NoState> {

    public AdamsonsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway10.class))
                .west(new Portal(true, BroadcastingRoom.class));
        this.title("Adamson's Room")
                .description(
                        "Banners hang from the ceiling proclaiming the acomplishments of Students.\n"
                        + " In the middle of the room lay 5 rows of highly advanced computers\n"
                        + " that are too complex for you to use. At the front of the room lie two\n"
                        + " fairly large moniters with a misterious golden key attached.\n"
                        + " There seems to be a 3D printed model of a giant troll that's blocking\n"
                        + " the enterance to the Broadcasting Room.\n"
                        + " There is a Post-It Note on his desk")
                .shortDescription("It's a Nerds paradise")
                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new Door(true, "Western Door", Sword.class, this.portals().west()))
                .item(new Troll3D());
    }
}

