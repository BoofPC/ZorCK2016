package areas;

import core.*;
import items.*;

public class Hallway03 extends Area<NoState> {

    public Hallway03(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway02.class))
                .south(new Portal(false, Hallway04.class))
                .west(new Portal(true, SecretPassage.class));
        this.title("Hallway").description("----------").shortDescription("-----").articleThe(true)

                .item(new Door(true, "Western Door", Key.SecretPassage.class,
                        this.portals().west()));
    }
}
