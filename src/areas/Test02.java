package areas;

import core.*;
import items.*;

public class Test02 extends Area{

       public Test02(final World containingWorld){
            super(containingWorld);
            this.getPortals().west(new Portal(false, "Test01"))
                .east(new Portal(false, "Test03"))
                .south(new Portal(false, "Test05"));
            this.setTitle("Test Area 2");
            this.setInitialDescription("This is the second test area, there is path "
                    + "leading east-west and a door to the south. There is a "
                    + "screwdriver on the ground");
            this.setDescription("This is the second test area");
            this.addItem(new Door(false,"Southern Door","Key",this.getPortals().south()));
            this.addItem(new Screwdriver());
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
