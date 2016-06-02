package areas;
import core.*;
import items.*;

/**
 *
 * @author pedro
 */
 
//This is a template for Area
//For a more thorough explanation, see TutorialArea
public class AreaTemplate extends Area{     //Be sure to replace this

       public AreaTemplate(World containingWorld){      //And this
            super(containingWorld);
            /* Set the ones you need
            setPortal(World.NORTH, new Portal(,""));
            setPortal(World.EAST, new Portal(, ""));
            setPortal(World.SOUTH, new Portal(, ""));
            setPortal(World.WEST, new Portal(, ""));
            */
            setTitle("");
            setInitialDescription("");
            setDescription("");
            //Add any necessary doors
            addItem(new Door(false,"DOORNAME", null,
                    getPortal(World.SOUTH/*DIRECTION THE DOOR IS FACING*/)));
            
            
            //Add these if you want
            //addItem(ITEM);
            //setTaste(STRING);
            //setSmell(STRING);
            //setSound(STRING);
            //setDark(BOOLEAN); //if the player needs the lantern to see

            
       }
       
        public void interact(Command command, Context construct){
                //if you don't have any special interactions, just put this:
                command.getVerb().run(command, construct);
        }
       
}
