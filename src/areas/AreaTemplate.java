package areas;

import core.*;
import items.*;

 
//This is a template for Area
//For a more thorough explanation, see TutorialArea
public class AreaTemplate extends Area{     //Be sure to replace this

       public AreaTemplate(World containingWorld){      //And this
            super(containingWorld);
            /* Set the ones you need
            getPortals()
                .north(new Portal(,""))
                .east(new Portal(, ""))
                .south(new Portal(, ""))
                .west(new Portal(, ""));
            */
            setTitle("");
            setInitialDescription("");
            setDescription("");
            //Add any necessary doors
            addItem(new Door(false,"DOORNAME", null,
                    getPortals().south()/*DIRECTION THE DOOR IS FACING*/));
            
            
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
            //if you don't have any special interactions, just put this:
            if(command.getNoun() !=  null)
                noun.interact(command,context);
            if(!context.getSkipGeneral())
                command.getVerb().run(command, context);
        }
       
}
