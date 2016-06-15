package areas;

import core.*;
import items.*;

/**
 *
 * @author pedro
 */


public class ArthursRoom extends Area {

    public ArthursRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, JorstadsRoom.class))
                .south(new Portal(false, StakersRoom.class))
                .west(new Portal(true, Hallway03.class));

        this.title("ArthursRoom").description(
                "This is ms.Arthurs room.Ms. Arthur is grading some papers at her desk using a red pen. Oh look a Frog Heart is on one of the tables."
                        + "To the south. There is Ms.Arthurs desk "
                        + "To the west. There Recycling binsTo the East. There are sinks")
                .shortDescription(
                        "Students are working on stuff. They are pretty much ignoring you right now.")
                //Add any necessary doors
                .item(new Door(false, "DOORNAME", null, this.portals().south()))

                .dark(false)
                //Add these if you want
                //addItem(ITEM);
                //setTaste(STRING);
                .smell("Because of the froges in the sink there is a formaldehyde smell ");
        //setSound(STRING);
        //setDark(BOOLEAN); //if the player needs the lantern to see


    }

}
