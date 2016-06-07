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
        setPortal(World.EAST, new Portal(false, "CrampedHall"));
        setPortal(World.UP, new Portal(true, "Roof"));
        setTitle("Area outside Band Room");
            setInitialDescription("This is a small space just outside the band"
                    + " room, with a zipline extending upward.");
            setState("First",true);
            setDark(false);
    }
    
    public void interact(Command command, Context context){
            if((command.verb.getTitle().equals("taste") && command.noun.getName().equals("room"))
                    || (command.verb.getTitle().equals("lick") && command.noun.getName().equals("room"))){
                System.out.println("You are outside, do you enjoy eating dirt?");
            }else if(command.verb.getTitle().equals("listen")){
                System.out.println("You hear wind in the trees nearby.");
            }else if(command.verb.getTitle().equals("smell")){
                System.out.println("You smell fresh air.");
            }else{
                command.verb.run(command, context);
            }
            
            command.verb.run(command, context);
                
        }
}
