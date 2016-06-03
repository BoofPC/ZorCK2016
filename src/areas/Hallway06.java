package areas;

import core.*;
import items.*;

public class Hallway06 extends Area{

       public Hallway06(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .north(new Portal(false,"Hallway05"))
                .south(new Portal(false, "Hallway08"))
                .west(new Portal(false, "WatchmansRoom"));
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(true,"Western Door", null,this.getPortals().west()));


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
