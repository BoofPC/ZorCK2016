package areas;

import core.*;
import items.*;

public class Test07 extends Area{

       public Test07(final World containingWorld){
            super(containingWorld);
            this.getPortals().east(new Portal(false, "Test08"))
                .north(new Portal(false, "Test04"));
            this.setTitle("Test Area 7");
            this.setInitialDescription("This is the seventh test area, there is a "
                    + "path to the east and to the north. There is a Lantern "
                    + "on the ground");
            this.setDescription("This is the seventh test area");
            this.addItem(new Lantern());
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
