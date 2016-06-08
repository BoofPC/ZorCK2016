package areas;

import core.*;
import items.*;

public class MensRestroom extends Area {

    public MensRestroom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, Hallway14.class));
        this.title("Men's Restroom").description("there are toilets and sinks and their is paper piled against the waste basket").shortDescription("Ketchup").articleThe(true)
                .item(new Door(false, "Southern Door", null, this.portals().south()));
        this.item(new Ketchup());
    }
}
