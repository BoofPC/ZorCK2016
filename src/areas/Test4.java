package areas;

import core.*;
import items.*;

public class Test4 extends Area{

       public Test4(World containingWorld){
            super(containingWorld);
            getPortals().north(new Portal(true, "Test1"))
                .east(new Portal(false, "Test5"))
                .south(new Portal(false, "Test7"));
            setTitle("Test Area 4");
            setInitialDescription("This is the fourth test area, there are paths"
                    + " to the east and south and a locked door to the north.");
            setDescription("This is the fourth test area"); 
            addItem(new Door(true,"Northern Door","Key",getPortals().north()));
            setState("First",true);
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
