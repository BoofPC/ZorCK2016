package areas;

import core.*;
import items.*;

public class Hallway01 extends Area<NoState> {

    public Hallway01(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, Hallway02.class))
                .northwest(new Portal(false, BirkenfeldsRoom.class));
        this.title("Hallway")
                .description(
                        "The school hallway must have been designed my a manic depressive, either that or someone obsessed by grey. The teachers had done their bit, hanging posters in primary colours, yet the overall impression was of drabness. Lily longed to paint the doors rainbow, or better yet blow off the roof and replace it with a glass dome. She could see plants in pots reaching up for the sunlight and butterflies flitting in-between. North West is Birkinfeld's room. ")
                .shortDescription(
                        "It's a drap hallway with a motivational poster saying you can do it cougs.  North West is Birkinfeld's room.")
                .articleThe(true)
                .item(new Door(false, "Northwestern Door", null, this.portals().northwest()));
    }
}
