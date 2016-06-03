package areas;

import core.*;
import items.*;

public class Test01 extends Area{

       public Test01(final World containingWorld){
            super(containingWorld);
            this.getPortals().east(new Portal(false, "Test02"))
                .south(new Portal(true, "Test04"));
            this.setTitle("Test Area 1");
            this.setInitialDescription("This is the first test area, there is path to "
                    + "the east and a locked door to the south. There is dark "
                    + "and white chocolate on the ground");
            this.setDescription("This is the first test area");
            this.addItem(new Door(true,"Southern Door", "Key",this.getPortals().south()));
            this.addItem(new DarkChocolate());
            this.addItem(new WhiteChocolate());
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
