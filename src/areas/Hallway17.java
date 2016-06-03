package areas;

import core.*;
import items.*;


public class Hallway17 extends Area{

       public Hallway17(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .north(new Portal(false, "FishersRoom"))
                .east(new Portal(false, "Hallwa16"));
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(false,"Northern Door", null,this.getPortals().north()));


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
