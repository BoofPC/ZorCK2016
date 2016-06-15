package areas;

import core.*;
import items.*;

public class Library extends Area<NoState> {

    public Library(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, ConferenceRoom01.class))
                .north(new Portal(false, ConferenceRoom02.class))
                .northeast(new Portal(false, SecretPassage.class))
                .west(new Portal(true, Hallway13.class));
        this.title("Library").description("----------").shortDescription("-----").articleThe(true)
                .item(new Door(false, "Southern Door", null, this.portals().south()))
                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new Door(false, "Northeastern Door", null, this.portals().northeast()))
                .item(new Door(true, "Western Door", Key.Library.class, this.portals().west()));
    }
}
