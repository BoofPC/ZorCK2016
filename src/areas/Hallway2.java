package areas;

import core.*;
import items.*;


public class Hallway2 extends Area{

       public Hallway2(World containingWorld){
            super(containingWorld);

            getPortals()
                .north(new Portal(false,"Hallway1"))
                .south(new Portal(false, "Hallway3"))
                .west(new Portal(false, "BoothsRoom"))
                .east(new Portal(false, "JorstadsRoom"));
            setTitle("Hallway");
            setInitialDescription("----------");
            setDescription("-----");

            addItem(new Door(false,"Western Door", null,getPortals().west()));
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
