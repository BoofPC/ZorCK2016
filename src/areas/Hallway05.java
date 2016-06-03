package areas;

import core.*;
import items.*;

public class Hallway05 extends Area{

       public Hallway05(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .north(new Portal(false,"Hallway04"))
                .south(new Portal(false, "Hallway06"))
                .west(new Portal(false, "CompSciRoom"))
                .east(new Portal(false, "SecurityRoom"));
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(true,"Western Door", null,this.getPortals().west()));
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
