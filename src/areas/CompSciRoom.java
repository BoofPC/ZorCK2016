package areas;

import core.*;
import items.*;

public class CompSciRoom extends Area {

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, Hallway05.class))
                .south(new Portal(true, WatchmansRoom.class));
        this.title("CompSci Room")
                //This is not a logical sentence structure
                .description("This is the CompSci room, Room 317."
                        + " Powerschool is open on Booth's computer. You see your grade is an F."
                        + " There is a door to the east that leads to Hallway05 and"
                        + " a locked door to the north that leads to Mrs. Wachtman's room.")
                .shortDescription("This is the CompSci Room, Room 317.").articleThe(true);
    }

    @Override
    public void interact(final Command command, final Context context) {
        super.interact(command, context);
    }
}
