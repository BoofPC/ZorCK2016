package areas;

import core.*;
import items.*;

public class Test06 extends Area{

       public Test06(World containingWorld){
            super(containingWorld);
            getPortals().north(new Portal(false, "Test03"))
                .west(new Portal(false, "Test05"))
                .south(new Portal(false, "Test09"));
            setTitle("Test Area 6");
            setInitialDescription("This is the sixth test area, there is path "
                    + "leading west and a path leading north-south. There is "
                    + "a key on the ground");
            setDescription("This is the sixth test area"); 
            addItem(new Key());
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
