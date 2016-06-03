package areas;

import core.*;
import items.*;

public class Hallway09 extends Area{

       public Hallway09(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .south(new Portal(false, "ISSRoom"))
                .west(new Portal(false, "Hallway10"))
                .east(new Portal(false, "Hallway08"));
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(true,"Southern Door", null,this.getPortals().south()));


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
