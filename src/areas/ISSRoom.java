package areas;

import core.*;
import items.*;

public class ISSRoom extends Area<NoState> {

    public ISSRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway09.class));
        this.title("ISS Room")
                .description("")
                .shortDescription("")
                .articleThe(true).dark(false).smell("Smells like delinquency")
                .taste("Tastes like failure").sound("It is absolutely silent")
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }

    @Override
    public void interact(final Command command, final Context construct) {
        super.interact(command, construct);
    }


}
