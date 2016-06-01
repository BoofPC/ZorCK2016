/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;
import core.*;
import items.*;
/**
 *
 * @author johnson5951a
 */
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
    public void interact(Command command, Context construct) {
        if(command.verb.equals("look")){
            System.out.println("You see scattered papers around the room, some"
                    + " saying 'You can get it if you really want' and others"
                    + " discussing the extent to which the Kyoto Protocol assisted"
                    + " United States' environmental impacts."
                    + " Nothing seems to be of interest in this room.");
        }
        
        if((command.verb.equals("get") || command.verb.equals("pick up")) && (command.noun.equals("paper") || command.noun.equals("papers"))){
            System.out.println("You feel a burning sensation as your legs and arms feel as if they"
                    + " are on fire. A faint voice in the distance yells 'Plagarism!'. You immediately"
                    + " drop the papers due to fright.");
        }
        
        else{
            System.out.println("You can't" + command.verb + command.noun + "in here!");
        }
    }
    
    
}