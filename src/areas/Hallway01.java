package areas;

import core.*;
import items.*;

public class Hallway01 extends Area{

       public Hallway01(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .north(new Portal(false,"RosenquistsRoom"))
                .south(new Portal(false, "Hallway02"))
                .west(new Portal(false, "HenrichsonsRoom"))
                .northwest(new Portal(false, "BirkenfeldsRoom"));
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(false,"Northern Door", null,this.getPortals().north()));
            this.addItem(new Door(false,"Western Door", null,this.getPortals().west()));
            this.addItem(new Door(false,"Northwestern Door", null,this.getPortals().northwest()));



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
