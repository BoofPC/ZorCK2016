package areas;

import core.*;
import items.*;

public class Hallway04 extends Area{

       public Hallway04(final World containingWorld){
            super(containingWorld);

            this.portals()
                .north(new Portal(false,Hallway03.class))
                .south(new Portal(false, Hallway05.class))
                .west(new Portal(false, WilsonsRoom.class))
                .east(new Portal(false, StakersRoom.class));
            this.title("Hallway")
                .description("----------").shortDescription("-----").articleThe(true)

                .item(new Door(true,"Western Door", null,this.portals().west()))
                .item(new Door(false,"Eastern Door", null,this.portals().east()));
       }
}
