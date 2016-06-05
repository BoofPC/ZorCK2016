package areas;

import core.*;
import items.MrBooth;

public class CompSciRoom extends Area{

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, "Hallway05"))
            .south(new Portal(false, "Wachtman's room"));
        //change the portal to go to hallway when hallway is made
        this.title("CompSci Room")
            .initialDescription("This is the CompSci room, Room 317. MrBooth is here in his chair,"
                +"infornt of his computer. on, his computer is PowerSchool. You see Your Grade is an F")
            .description("This is the CompSci Room, room 317")
            .item(new MrBooth());
    }

}
