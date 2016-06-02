package areas;

import core.*;
import items.*;

public class FishersRoom extends Area {

    public FishersRoom(World containingWorld) {
        super(containingWorld);
        setPortal(World.NORTH, new Portal(Portal.UNLOCKED, "Hallway17"));
        setInitialDescription("You are in Fisher's room as various papers on "
                + "the downfall of the Ming Empire and essays as well as Silk "
                + "Roads trading changed China while a Reggae-sounding song "
                + "blares through the speakers.");
        setDescription("This is Fisher's room, it smells vaguely of perspiration "
                + "and the Spanish Inquisition.");
        setDark(false);
        setSmell("It smells like teen spirit (or in other words perspiration)");
        setTaste("You taste good ol' oxygen");
        setSound("Blaring reggae music pounds through your ear drums");
        addItem(new Door(false, "Northern Door", new Key(), getPortal(World.NORTH)));
    }

    @Override
    public void interact(Command command, Context context) {
        Item noun;
        noun = command.getNoun();
        if(command.getVerb().equals("look")){
            System.out.println("You see scattered papers around the room, some"
                    + " saying 'You can get it if you really want' and others"
                    + " discussing the extent to which the Kyoto Protocol assisted"
                    + " United States' environmental impacts."
                    + " Nothing seems to be of interest in this room.");
        }
        
        if((command.getVerb().equals("get") || command.getVerb().equals("pick up")) && (command.getNoun().equals("paper") || command.getNoun().equals("papers"))){
            System.out.println("You feel a burning sensation as your legs and arms feel as if they"
                    + " are on fire. A faint voice in the distance yells 'Plagarism!'. You immediately"
                    + " drop the papers due to fright.");
        }
        
        else{
            if(command.getNoun() !=  null)
                noun.interact(command,context);
            if(!context.getSkipGeneral())
                command.getVerb().run(command, context);
        }
    }
    
    
}
