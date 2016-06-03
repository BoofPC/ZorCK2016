package areas;

import core.*;
import items.*;

public class Test05 extends Area{

       public Test05(World containingWorld){
            super(containingWorld);
            getPortals().north(new Portal(false, "Test02"))
                .west(new Portal(false, "Test04"))
                .east(new Portal(false, "Test06"))
                .south(new Portal(false, "Test08"));
            setTitle("Test Area 5");
            setInitialDescription("This is the fifth test area, there is path "
                    + "leading east-west, a door to the north, and a path to "
                    + "the south.");
            setDescription("This is the fifth test area");   
            addItem(new Door(false,"Northern Door","Key",getPortals().north()));
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
