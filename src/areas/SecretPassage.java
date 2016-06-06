package areas;

import core.*;
import items.*;

public class SecretPassage extends Area {

    public SecretPassage(final World containingWorld) {
        super(containingWorld);

        this.portals().east(new Portal(true, Hallway03.class))
                .south(new Portal(false, Library.class));
        this.title("Secret Passage").initialDescription("----------").description("-----").articleThe(true)
                .item(new Door(true, "Eastern Door", "Secret Passage Key", this.portals().east()))
                .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
