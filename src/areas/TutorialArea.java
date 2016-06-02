package areas;

import core.*;
import items.*;

/**
 * Tutorial area based on {@link Test1}.
 */
public class TutorialArea extends Area{

   public TutorialArea(World containingWorld){
        super(containingWorld);                                                     //Always have this
        setPortal(World.EAST, new Portal(Portal.UNLOCKED, "Test2"));                //Portals leading east to Test2 and south to Test4
        setPortal(World.SOUTH, new Portal(Portal.LOCKED, "Test4"));                 //The way to Test4 is blocked
        setTitle("Test Area 1");                                                    //This is the title of the area, it appears every move for which the player is in the area
        setInitialDescription("This is the first test area, there is path to "      //This is the description of the area which appears when the player initially enters
                + "the east and a locked door to the south. There is dark "       
                + "and white chocolate on the ground");
        setDescription("This is the first test area");                              //This is the description of the area which appears when the player inputs LOOK
        addItem(new Door(true,"Southern Door", new Key(),getPortal(World.SOUTH)));  //The way to the south is blocked by a door, named "Southern Door", which uses the Key() item as a key and is connected to the southern portal
        addItem(new DarkChocolate());                                               //This room contains both dark and white chocolate
        addItem(new WhiteChocolate());
   }
   
    //if you don't have any special interactions, just put this
    //to see how special interactions work, see Test8
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
