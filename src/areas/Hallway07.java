package areas;

import core.*;
import items.*;

public class Hallway07 extends Area {

    public Hallway07(final World containingWorld) {
        super(containingWorld);

        this.portals()
            .north(new Portal(Portal.State.UNLOCKED, "WomensRestroom"))
            .west(new Portal(Portal.State.UNLOCKED, "Hallway08"));

        this.title("Hallway")
            .initialDescription("This is the end of the hallway. To the north is "
                + "a doorway that leads to the women's restroom. Off to the "
                + "side is a staircase that has been barricaded with chairs. "
                + "The hallway continues to the west. A stale cracker lies in "
                + "the center of the hallway.").articleThe(true)
            .description("This is the end of the hallway.")

            .item(new Cracker());
    }
}