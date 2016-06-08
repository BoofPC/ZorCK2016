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
import items.Vibraphone;

/**
 *
 * @author flowers9695r
 */
public class BandRoom extends Area{
    
    public BandRoom(World containingWorld){
        super(containingWorld);
        this.portals().south(new Portal(false, CrampedHall.class));
        this.title("Band Room")
        .initialDescription("This is an incredibly large room, but a"
                    + " boiler that appears to have fallen through the celing"
                    + " takes up most of it. Behind it are multiple strange instruments."
                    + " One vaugely reminds you of a piano.")
        .description("This is the band room.").state("First",true)
        .item(new Vibraphone()).dark(true);
    }
    
    @Override
    public void interact(final Command command, final Context context){
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();
        
        if((verb.equals("taste") || verb.equals("lick")) && noun.equals("room")){
            System.out.println("Why would you want to lick the room?"
                    + " People dumped their spit valves out on the floor!");
        }else if(verb.equals("listen")){
            System.out.println("You faintly hear echos of crying children and poorly played music.");
        }else if(verb.equals("smell")){
            System.out.println("You smell sweat and pain.");
        }else{
            super.interact(command, context);
        }           
    }
}
