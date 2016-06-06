package areas;

import core.*;
import items.*;


public class BroadcastingRoom extends Area {

    public BroadcastingRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway11.class))
                .east(new Portal(true, AdamsonsRoom.class));
        this.title("Broadcasting Room").initialDescription("----------").description("-----").articleThe(true)
                .item(new Door(false, "Northern Door", null, this.portals().north()))
                .item(new Door(true, "Eastern Door", "Adamson's Key", this.portals().east()));

        this.initialDescription("You eneter a room of depressed possiblitities. "
                + "Great things once happened here, "
                + "but no longer.");
        this.description("");
        // Add any necessary doors
        // (Here, the door faces south)
        this.item(new Door(false, "Door to Mr Adamson's room", null, this.portals().west()));

        
        this.item(new DuckOfDoom());
        this.item(new LaserPointer());
    }

    @Override
    public void interact(Command command, Context context) {
         //To change body of generated methods, choose Tools | Templates.
    }
}
