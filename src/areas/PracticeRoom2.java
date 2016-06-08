/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;

import core.Area;
import core.Command;
import core.Context;
import core.Portal;
import core.World;
import items.Cupboard;

// Room: PracticeRoom2
// North: CrampedHall1
// East: wall
// West: wall
// South: wall
// Initial Description: A cupboard stands in the corner, and the place looks ransacked. A door leads to the north.
// Description: This is the second practice room
// Dark?: True
// Smell: You smell old sweat.
// Sound: You hear echos of your breathing
// Taste: Why would you want to lick the room? People dumped their spit valves out on the floor!
// Special States: n/a
// Items in room: Piano

/**
 *
 * @author flowers9695r
 */
public class PracticeRoom2 extends Area{
    
    public PracticeRoom2(World containingWorld){
        super(containingWorld);
        this.portals().north(new Portal(false, CrampedHall.class));
        this.title("Second Practice Room")
        .initialDescription("This is the second practice room, with a doorway "
                    + "leading north. A cupboard stands against the east wall, but"
                    + " the place looks ransacked.")
        .description("This is the second practice room.").state("First",true)
        .item(new Cupboard()).dark(true);
    }
    
    @Override
    public void interact(final Command command, final Context context){
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();
        
        if((verb.equals("taste") || verb.equals("lick")) && noun.equals("room")){
            System.out.println("Why would you want to lick the room?"
                    + " People dumped their spit valves out on the floor!");
        }else if(verb.equals("listen")){
            System.out.println("You hear the echos of your breathing.");
        }else if(verb.equals("smell")){
            System.out.println("You smell old sweat.");
        }else{
            super.interact(command, context);
        }
    }
}
