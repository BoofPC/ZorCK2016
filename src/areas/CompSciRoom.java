package areas;

import core.*;
import items.*;
public class CompSciRoom extends Area{

    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.getPortals().east(new Portal(false, "Hallway05"))
            .south(new Portal(true, "Wachtman's room"));
        this.setTitle("CompSci Room");
        this.setInitialDescription("This is the CompSci room, Room 317. MrBooth is here in his chair,"
                +"infornt of his computer. On his computer monitor, you see that power school is open, and your grade is an F."
                +" There is a door to the east that leads to Hallway05 and a locked door to the north that leads to Mrs.Wachtman's room ");
        this.setDescription("This is the CompSci Room, room 317");   
        this.addItem(new MrBooth());
        
    }

        @Override
        public void interact(final Command command, final Context context){
            Item noun;
            noun = command.getNoun();
            //TODO: Make ending play when player has blackmail
            if(context.getPlayer().hasMatching("BlackMail"));
            //if you don't have any special interactions, just put this:
            if(command.getNoun() !=  null) {
                noun.interact(command,context);
            }
            if(!context.getSkipGeneral()) {
                command.getVerb().run(command, context);
                //TODO: have a function to lure boof out
            }
        }



}
