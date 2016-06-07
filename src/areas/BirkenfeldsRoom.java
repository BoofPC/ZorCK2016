package areas;

import core.*;
import items.*;

public class BirkenfeldsRoom extends Area {

    public BirkenfeldsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().southeast(new Portal(false, Hallway01.class))
                .north(new Portal(true, ChemicalStorageRoom.class));
        this.title("Birkenfeld's Room").initialDescription("This is Mr.Birkenfelds room. As you walk into the classroom you hear Mr.Birkenfeld yelling at his students to do their packets. Your ears starts to hurt. This room is very messy. You see the door to the Chemical Storage Room to the north.").description("This is Mr.Birkenfelds room. The room is very messy and your ears hurt. You see the door to the Chemical Storage Room to the north.")
                .item(new Door(false, "Southeastern Door", null, this.portals().southeast()))
                .item(new Door(true, "Northern Door", null, this.portals().north()));
    }
    
    @Override
    public void interact(final Command command, final Context context) {
        if (command.getVerb().getTitle().equals("talk")
                && command.getNoun().name().equals("mr.birkenfeld") 
                || command.getNoun().name().equals("birkenfeld")) {
            this.portals().north(new Portal(false, ChemicalStorageRoom.class));
            item(new Door(false, "Northern Door", null, this.portals().north()));
            System.out.println("Hey, do your packets!!!");
            System.out.println("Sorry, can you get me Chemical A?");
            System.out.println("I'll open the Chemical Storage Room for you");
        } else {
            command.getVerb().run(command, context);
        }

        command.getVerb().run(command, context);
    }
    
}
