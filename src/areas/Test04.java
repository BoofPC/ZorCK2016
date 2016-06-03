package areas;

import core.*;
import items.*;

public class Test04 extends Area{

       public Test04(final World containingWorld){
            super(containingWorld);
            this.getPortals().north(new Portal(true, "Test01"))
                .east(new Portal(false, "Test05"))
                .south(new Portal(false, "Test07"));
            this.setTitle("Test Area 4");
            this.setInitialDescription("This is the fourth test area, there are paths"
                    + " to the east and south and a locked door to the north.");
            this.setDescription("This is the fourth test area");
            this.addItem(new Door(true,"Northern Door","Key",this.getPortals().north()));
            this.setState("First",true);
       }

    @Override
    public void interact(final Command command, final Context context){
        Item noun;
        noun = command.getNoun();
        //if you don't have any special interactions, just put this:
        if(command.getNoun() !=  null) {
            noun.interact(command,context);
        }
        if(!context.getSkipGeneral()) {
            command.getVerb().run(command, context);
        }
    }
}
