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

/**
 *
 * @author flowers9695r
 */
public class LandingPad extends Area{
    
    public LandingPad(World containingWorld){
        super(containingWorld);
        this.portals().east(new Portal(false, CrampedHall.class));
        this.portals().up(new Portal(true, Roof.class));
        this.title("Area outside Band Room")
        .initialDescription("This is a small space just outside the band"
                    + " room, with a zipline extending upward.")
        .state("First",true).dark(false);
    }
    
    @Override
    public void interact(Command command, Context context){
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();
        
        if((verb.equals("taste") || verb.equals("lick")) && noun.equals("room")){
            System.out.println("You are outside, do you enjoy eating dirt?");
        }else if(verb.equals("listen")){
            System.out.println("You hear wind in the trees nearby.");
        }else if(verb.equals("smell")){
            System.out.println("You smell fresh air.");
        }else{
            super.interact(command, context);
        }            
    }
}
