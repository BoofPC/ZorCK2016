package areas;

import core.*;
import items.*;


public class Hallway16 extends Area{

       public Hallway16(World containingWorld){
            super(containingWorld);

            getPortals()
                .north(new Portal(false, "SchuchartsRoom"))
                .south(new Portal(false, "KasslersRoom"))
                .west(new Portal(false, "Hallway17"))
                .east(new Portal(false, "Hallwa15"));
            setTitle("Hallway");
            setInitialDescription("----------");
            setDescription("-----");

            addItem(new Door(false,"Northern Door", null,getPortals().north()));
            addItem(new Door(false,"Southern Door", null,getPortals().south()));
            
            
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
