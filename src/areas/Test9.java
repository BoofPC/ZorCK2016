package areas;

import core.*;
import core.World.Direction;
import items.*;

public class Test9 extends Area{

       public Test9(World containingWorld){
            super(containingWorld);
            getPortals().setPortal(Direction.WEST, new Portal(false, "Test8"));
            getPortals().setPortal(Direction.NORTH, new Portal(false, "Test6"));
            setTitle("Test Area 9");
            setInitialDescription("This is the ninth test area, there is path "
                    + "leading west and a path leading north. There is a "
                    + "Hamburger on the ground.");
            setDescription("This is the ninth test area");   
            setState("First",true);
            addItem(new Hamburger());
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
