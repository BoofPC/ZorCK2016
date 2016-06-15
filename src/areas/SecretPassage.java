package areas;

import core.*;
import items.*;

public class SecretPassage extends Area<NoState> {

    public SecretPassage(final World containingWorld) {
        super(containingWorld);

        this.portals().east(new Portal(true, Hallway03.class))
                .south(new Portal(false, Library.class));
        this.description("An empty ramp that inclines upward as you head to the library")
                .shortDescription("DARK. AND DANK. DARNK.Yes you are in the secret passage")
                .articleThe(true).dark(true).smell("Vaguely mold and rot")
                .sound("Quiet humming of the air conditioning").taste("Moldy")
                .item(new Door(true, "Eastern Door", Key.SecretPassage.class,
                        this.portals().east()))
                .item(new Door(true, "Southern Door", null, this.portals().south()));
    }


}
