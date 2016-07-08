package areas;

import core.*;
import items.*;

/**
 *
 * @author pedro
 */


public class ArthursRoom extends Area<NoState> {

    public ArthursRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, JorstadsRoom.class))
                .south(new Portal(false, StakersRoom.class))
                .west(new Portal(true, Hallway03.class));

        this.title("ArthursRoom").description("")
                .item(new Door(true, "Western Door", null, this.portals().west()))

                .dark(false)
                //Add these if you want
                //addItem(ITEM);
                //setTaste(STRING);
                .smell("It smells of formaldehyde");
        //setSound(STRING);
        //setDark(BOOLEAN); //if the player needs the lantern to see


    }

}
