package areas;

import core.*;
import items.*;

public class Test07 extends Area{

       public Test07(World containingWorld){
            super(containingWorld);
            getPortals().east(new Portal(false, "Test08"))
                .north(new Portal(false, "Test04"));
            setTitle("Test Area 7");
            setInitialDescription("This is the seventh test area, there is a "
                    + "path to the east and to the north. There is a Lantern "
                    + "on the ground");
            setDescription("This is the seventh test area");
            addItem(new Lantern());
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
