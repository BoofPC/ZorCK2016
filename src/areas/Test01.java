package areas;

import core.*;
import items.*;

public class Test01 extends Area{

       public Test01(World containingWorld){
            super(containingWorld);
            getPortals().east(new Portal(false, "Test02"))
                .south(new Portal(true, "Test04"));
            setTitle("Test Area 1");
            setInitialDescription("This is the first test area, there is path to "
                    + "the east and a locked door to the south. There is dark "
                    + "and white chocolate on the ground");
            setDescription("This is the first test area");   
            addItem(new Door(true,"Southern Door", "Key",getPortals().south()));
            addItem(new DarkChocolate());
            addItem(new WhiteChocolate());
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
