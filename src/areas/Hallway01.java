package areas;

import core.*;
import items.*;

public class Hallway01 extends Area {

    public Hallway01(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, RosenquistsRoom.class))
                .south(new Portal(false, Hallway02.class))
                .west(new Portal(false, HendrichsonsRoom.class))
                .northwest(new Portal(false, BirkenfeldsRoom.class));
        this.title("Hallway")
                .description(
                        "The school hallway must have been designed my a manic depressive, either that or someone obsessed by grey. The teachers had done their bit, hanging posters in primary colours, yet the overall impression was of drabness. Lily longed to paint the doors rainbow, or better yet blow off the roof and replace it with a glass dome. She could see plants in pots reaching up for the sunlight and butterflies flitting in-between. North is Rosenquest's room to the North West is Birkinfeld's room and to the west is Henrichson's room. ")
                .shortDescription(
                        "It's a drap hallway with a motivational poster saying you can do it cougs.  North is Rosenquest's room to the North West is Birkinfeld's room and to the west is Henrichson's room")
                .articleThe(true)

                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new Door(false, "Western Door", null, this.portals().west()))
                .item(new Door(false, "Northwestern Door", null, this.portals().northwest()));
    }
}
