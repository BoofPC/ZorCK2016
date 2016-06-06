package areas;

import core.*;
import items.MrBooth;

public class CompSciRoom extends Area{

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, Hallway05.class))
            .south(new Portal(false, WatchmansRoom.class));
        this.title("CompSci Room")
                 //This is not a logical sentence structure
                .initialDescription("This is the CompSci room, Room 317. Mr Booth is here in his chair,"
                    +" in front of his computer. Powerschool is open on his computer. You see your grade is an F.")
                .description("This is the CompSci Room, room 317.").articleThe(true)
                .item(new MrBooth());
    }

}
