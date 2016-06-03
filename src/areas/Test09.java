package areas;

import core.*;
import items.*;

public class Test09 extends Area{

       public Test09(final World containingWorld){
            super(containingWorld);
            this.getPortals().west(new Portal(false, "Test08"))
                .north(new Portal(false, "Test06"));
            this.setTitle("Test Area 9");
            this.setInitialDescription("This is the ninth test area, there is path "
                    + "leading west and a path leading north. There is a "
                    + "Hamburger on the ground.");
            this.setDescription("This is the ninth test area");
            this.setState("First",true);
            this.addItem(new Hamburger());
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
