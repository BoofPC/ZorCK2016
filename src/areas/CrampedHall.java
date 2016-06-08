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
import items.Piano;

/**
 *
 * @author flowers9695r
 */
public class CrampedHall extends Area{
    
    public CrampedHall(World containingWorld){
        super(containingWorld);
        this.portals().south(new Portal(false, PracticeRoom1.class));
        this.portals().east(new Portal(false, PracticeRoom2.class));
        this.portals().west(new Portal(false, LandingPad.class));
        this.portals().north(new Portal(false, BandRoom.class));
        this.title("Cramped Hallway")
        .initialDescription("This is a very cramped hallway, with a"
                    + " doorway at each of the four cardinal directions."
                    + " This place seems as though it was once full of hope.")
        .description("This is the cramped hallway.").state("First",true)
        .dark(true);
    }
    
    @Override
    public void interact(final Command command, final Context context){
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();
        
        if((verb.equals("taste") || verb.equals("lick")) && noun.equals("room")){
            System.out.println("Why would you want to lick the room?"
                    + " People dumped their spit valves out on the floor!");
        }else if(verb.equals("listen")){
            System.out.println("You hear echos of chromatic scales being played very terribly.");
        }else if(verb.equals("smell")){
            System.out.println("You smell rotting school lunches.");
        }else{
            super.interact(command, context);
        }    
    }
}
