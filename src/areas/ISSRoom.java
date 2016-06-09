package areas;

import core.*;
import items.*;

public class ISSRoom extends Area {

    public ISSRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway09.class));
        this.title("ISS Room").description("You are in the ISS Room, you notice papers randomly scattered across the floor. There is no teacher in the room, yet there is absolute silence")
                .shortDescription("This is the ISS Room, it smells of delinquency, and is absolutely silent.").articleThe(true)
        .dark(false)
        .smell("Smells like delinquency")
        .taste("Tastes like failure")
        .sound("It is absolutely silent")
        .item(new Door(false, "Northern Door", null, this.portals().north()));       
    }
     @Override
    public void interact(Command command, Context construct) {
        if(command.getVerb().equals("look")){
            System.out.println("You see scattered papers around the room,"
                    + " many desks are lined up. There is a"
                    + " group of recycling bins in the corner of the room."
                    );
        }
        
        if((command.getVerb().equals("open") || command.getVerb().equals("unseal")) && (command.getNoun().equals("bin") || command.getNoun().equals("recycling bin"))){
            System.out.println("You picked up the key!");
                    construct.getPlayer().addItem(new Key());                    
        }
        
        else{
            System.out.println("The desks are empty!");
        }
    }
    
    
}