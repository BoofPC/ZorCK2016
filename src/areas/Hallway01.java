package areas;

import core.*;
import items.*;


public class Hallway01 extends Area{

       public Hallway01(World containingWorld){
            super(containingWorld);

            getPortals()
                .north(new Portal(false,"RosenquistsRoom"))
                .south(new Portal(false, "Hallway2"))
                .west(new Portal(false, "HenrichsonsRoom"))
                .northwest(new Portal(false, "BirkenfeldsRoom"));
            setTitle("Hallway");
            setInitialDescription("----------");
            setDescription("-----");

            addItem(new Door(false,"Northern Door", null,getPortals().north()));
            addItem(new Door(false,"Western Door", null,getPortals().west()));
            addItem(new Door(false,"Northwestern Door", null,getPortals().northwest()));
            
            
            
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
