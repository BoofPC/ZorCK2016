package areas;

import core.*;
import items.*;

public class CompSciRoom extends Area{
    
    public CompSciRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, Hallway05.class))
            .south(new Portal(true, WatchmansRoom.class));
        this.title("CompSci Room")
                 //This is not a logical sentence structure
                .description("This is the CompSci room, Room 317."
                    +" Powerschool is open on Booth's computer. You see your grade is an F."
                    +" There is a door to the east that leads to Hallway05 and a locked door to the north that leads to Mrs.Wachtman's room ")
                .shortDescription("This is the CompSci Room, Room 317.").articleThe(true)
                .item(new MrBooth());
    }

        @Override
        public void interact(final Command command, final Context context){
            final Player player = context.getPlayer();
            if(context.getPlayer().hasMatching(new Blackmail())) {
                System.out.println("You blackmail Booth into grading an assinment worth 100000000 points");
                player.setDeath(Game.Status.WIN);
            }
            if(context.getPlayer().hasMatching(new Screwdriver())) {
                System.out.println("you tamper with booth's chair. He falls and leaves to get a new chair.");
                this.removeItem(new MrBooth());
            }
            super.interact(command, context);
        }
}
