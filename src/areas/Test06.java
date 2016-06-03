package areas;

import core.*;
import items.*;

public class Test06 extends Area{

       public Test06(final World containingWorld){
            super(containingWorld);
            this.getPortals().north(new Portal(false, "Test03"))
                .west(new Portal(false, "Test05"))
                .south(new Portal(false, "Test09"));
            this.setTitle("Test Area 6");
            this.setInitialDescription("This is the sixth test area, there is path "
                    + "leading west and a path leading north-south. There is "
                    + "a key on the ground");
            this.setDescription("This is the sixth test area");
            this.addItem(new Key());
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
