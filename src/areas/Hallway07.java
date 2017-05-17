package areas;

import core.*;
import items.*;

public class Hallway07 extends Area<NoState> {

    public Hallway07(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(Portal.State.UNLOCKED, WomensRestroom.class))
                .west(new Portal(Portal.State.UNLOCKED, Hallway08.class));

        this.title("Hallway")
                .description("This is the end of the hallway. To the north is "
                        + "a doorway that leads to the women's restroom. Off to the "
                        + "side is a staircase that has been barricaded with chairs. "
                        + "The hallway continues to the west. A stale cracker lies in "
                        + "the center of the hallway.")
                .articleThe(true).shortDescription("This is the end of the hallway.");
    }
}
