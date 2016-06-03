package areas;

import core.*;

public class Test10 extends Area{

       public Test10(final World containingWorld){
            super(containingWorld);
            this.getPortals().north(new Portal(false, "Test08"));
            this.setTitle("Test Area 10");
            this.setInitialDescription("This is the tenth test area. You are in a "
                    + "cave! There is exit to the north");
            this.setDescription("This is the tenth test area");
            this.setState("First",true);
            this.setDark(true);
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
