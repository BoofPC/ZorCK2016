package areas;

import core.*;
import core.World.Direction;
import items.*;

public class Test2 extends Area{

       public Test2(World containingWorld){
            super(containingWorld);
            getPortals().setPortal(Direction.WEST, new Portal(false, "Test1"));
            getPortals().setPortal(Direction.EAST, new Portal(false, "Test3"));
            getPortals().setPortal(Direction.SOUTH, new Portal(false, "Test5"));
            setTitle("Test Area 2");
            setInitialDescription("This is the second test area, there is path "
                    + "leading east-west and a door to the south. There is a "
                    + "screwdriver on the ground");
            setDescription("This is the second test area");
            addItem(new Door(false,"Southern Door",new Key(),getPortals().getPortal(Direction.SOUTH)));
            addItem(new Screwdriver());
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
