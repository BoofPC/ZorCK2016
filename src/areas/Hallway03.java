package areas;

import core.*;
import items.*;

public class Hallway03 extends Area{

       public Hallway03(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .north(new Portal(false,"Hallway02"))
                .south(new Portal(false, "Hallway04"))
                .west(new Portal(true, "SecretPassage"))
                .east(new Portal(false, "ArthursRoom"));
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(true,"Western Door", "Key to Secret Passage",this.getPortals().west()));
            this.addItem(new Door(false,"Eastern Door", null,this.getPortals().east()));


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
