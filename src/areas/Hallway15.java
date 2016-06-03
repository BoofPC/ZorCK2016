package areas;

import core.*;
import items.*;


public class Hallway15 extends Area{

       public Hallway15(final World containingWorld){
            super(containingWorld);

            this.getPortals()
                .north(new Portal(false, "OishisRoom"))
                .south(new Portal(false, "GharstsRoom"))
                .west(new Portal(false, "Hallway16"))
                .east(new Portal(false, "Hallwa14"));
            this.setTitle("Hallway");
            this.setInitialDescription("----------");
            this.setDescription("-----");

            this.addItem(new Door(false,"Northern Door", null,this.getPortals().north()));
            this.addItem(new Door(false,"Southern Door", null,this.getPortals().south()));


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
