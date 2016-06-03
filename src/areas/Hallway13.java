package areas;

import core.*;
import items.*;


public class Hallway13 extends Area{

       public Hallway13(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .south(new Portal(false, "Hallway12"))
                .east(new Portal(true, "Library"));     //Door to the library is locked
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(true,"Library Door", "Library Key",this.getPortals().east()));


            //Add these if you want
            //addItem(ITEM);
            //setTaste(STRING);
            //setSmell(STRING);
            //setSound(STRING);
            //setDark(BOOLEAN); //if the player needs the lantern to see


       }

        @Override
        public void interact(final Command command, final Context context){
            Item noun;
            noun = command.getNoun();

            if(command.getNoun() !=  null) {
                noun.interact(command,context);
            }
            if(!context.getSkipGeneral()) {
                command.getVerb().run(command, context);
            }
        }

}
