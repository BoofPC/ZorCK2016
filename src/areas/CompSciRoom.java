package areas;

import core.*;

public class CompSciRoom extends Area{

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.getPortals().east(new Portal(false, "Hallway05"))
            .south(new Portal(false, "Wachtman's room"));
        //change the portal to go to hallway when hallway is made
        this.setTitle("CompSci Room");
        this.setInitialDescription("This is the CompSci room, Room 317.");
        this.setDescription("This is the CompSci Room, room 317");

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
