package areas;

import core.*;
import items.*;

public class WatchmansRoom extends Area {

    public WatchmansRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().east(new Portal(false, Hallway06.class))
                .north(new Portal(true, CompSciRoom.class));
        this.title("Watchman's Room").description("This is Mrs.Watchman's room. Mrs.Watchman is in the room tring to find the key to the CompSci room." 
                +"There is a door the the north that leads to the CompSci room, and a door to the east that leads to hallway06").shortDescription("This is Mrs.Watchman's room.")
                .item(new Door(false, "Eastern Door", null, this.portals().east()))
                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new MrsWatchman());
    }
}
