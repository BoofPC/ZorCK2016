package areas;

import core.*;
import items.MrBooth;

public class CompSciRoom extends Area{

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, "Hallway05"))
            .south(new Portal(false, "WatchmansRoom"));
        this.title("CompSci Room")
                 //This is not a logical sentence structure
                .initialDescription("This is the CompSci room, Room 317. Mr Booth is here in his chair,"
                    +"infornt of his computer. on, his computer is PowerSchool. You see Your Grade is an F")
                .description("This is the CompSci Room, room 317").articleThe(true)
                .item(new MrBooth());
    }

}
