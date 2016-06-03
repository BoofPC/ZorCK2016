package areas;

import core.*;
import items.*;


public class Hallway03 extends Area{

       public Hallway03(World containingWorld){
            super(containingWorld);

            getPortals()
                .north(new Portal(false,"Hallway2"))
                .south(new Portal(false, "Hallway4"))
                .west(new Portal(true, "SecretPassage"))
                .east(new Portal(false, "ArthursRoom"));
            setTitle("Hallway");
            setInitialDescription("----------");
            setDescription("-----");

            addItem(new Door(true,"Western Door", "Key to Secret Passage",getPortals().west()));
            addItem(new Door(false,"Eastern Door", null,getPortals().east()));
            
            
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
