package areas;

import core.*;
import items.*;


public class Hallway9 extends Area{

       public Hallway9(World containingWorld){
            super(containingWorld);

            getPortals()
                .south(new Portal(false, "ISSRoom"))
                .west(new Portal(false, "Hallway10"))
                .east(new Portal(false, "Hallway8"));
            setTitle("Hallway");
            setInitialDescription("----------");
            setDescription("-----");

            addItem(new Door(true,"Southern Door", null,getPortals().south()));
            
            
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
