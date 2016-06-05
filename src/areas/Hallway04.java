package areas;

import core.*;
import items.*;

public class Hallway04 extends Area{

       public Hallway04(final World containingWorld){
            super(containingWorld);

            this.portals()
                .north(new Portal(false,"Hallway03"))
                .south(new Portal(false, "Hallway05"))
                .west(new Portal(false, "WilsonsRoom"))
                .east(new Portal(false, "StakersRoom"));
            this.title("Hallway")
                .initialDescription("----------")
                .description("-----")

                .item(new Door(true,"Western Door", null,this.portals().west()))
                .item(new Door(false,"Eastern Door", null,this.portals().east()));
       }
}
