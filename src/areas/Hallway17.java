package areas;

import core.*;
import items.*;


public class Hallway17 extends Area{

       public Hallway17(World containingWorld){
            super(containingWorld);

            getPortals()
                .north(new Portal(false, "FishersRoom"))
                .east(new Portal(false, "Hallwa16"));
            setTitle("Hallway");
            setInitialDescription("----------");
            setDescription("-----");

            addItem(new Door(false,"Northern Door", null,getPortals().north()));
            
            
            //Add these if you want
            //addItem(ITEM);
            //setTaste(STRING);
            //setSmell(STRING);
            //setSound(STRING);
            //setDark(BOOLEAN); //if the player needs the lantern to see

            
       }
       
        @Override
        public void interact(Command command, Context context){
            Item noun;
            noun = command.getNoun();

            if(command.getNoun() !=  null)
                noun.interact(command,context);
            if(!context.getSkipGeneral())
                command.getVerb().run(command, context);
        }
       
}
