package areas;

import core.*;
import items.*;

public class HendrichsonsRoom extends Area<NoState> {

    public HendrichsonsRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().west(new Portal(Portal.State.UNLOCKED, Hallway01.class));
        this.description("You are in Hendrichson's room. It contains lab benches "
                + "with chemicals and physics projects. You see a balloon on the floor "
                + "that looks as if it has been recently used.")
                .shortDescription("You are in Hendrichson's room.")
                .smell("It smells like sodium chloride.")
                .sound("You don't hear anything. It is eerie...")
                .item(new Door(false, "Western Door", null, this.portals().west()));
    }

    @Override
    public void interact(final Command command, final Context context) {
        super.interact(command, context);
    }
}
