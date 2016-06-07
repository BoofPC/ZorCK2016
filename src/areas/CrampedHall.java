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
        setPortal(World.SOUTH, new Portal(false, "PracticeRoom1"));
        setPortal(World.EAST, new Portal(false, "PracticeRoom2"));
        setPortal(World.WEST, new Portal(false, "LandingPad"));
        setPortal(World.NORTH, new Portal(false, "BandRoom"));
        setTitle("Cramped Hallway");
            setInitialDescription("This is a very cramped hallway, with a"
                    + " doorway at each of the four cardinal directions."
                    + " This place seems as though it was once full of hope.");
            setDescription("This is the cramped hallway.");
            setState("First",true);
            setDark(true);
    }
    
    public void interact(Command command, Context context){
            if((command.verb.getTitle().equals("taste") && command.noun.getName().equals("room"))
                    || (command.verb.getTitle().equals("lick") && command.noun.getName().equals("room"))){
                System.out.println("Why would you want to lick the room?"
                        + " People dumped their spit valves out on the floor!");
            }else if(command.verb.getTitle().equals("listen")){
                System.out.println("You hear echos of chromatic scales being played very terribly.");
            }else if(command.verb.getTitle().equals("smell")){
                System.out.println("You smell rotting school lunches.");
            }else{
                command.verb.run(command, context);
            }
            
            command.verb.run(command, context);
                
        }
}
