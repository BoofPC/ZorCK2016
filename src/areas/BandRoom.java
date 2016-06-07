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
        setPortal(World.SOUTH, new Portal(false, "CrampedHall"));
        setTitle("Band Room");
            setInitialDescription("This is an incredibly large room, but a"
                    + " boiler that appears to have fallen through the celing"
                    + " takes up most of it. Behind it are multiple strange instruments."
                    + " One vaugely reminds you of a piano.");
            setDescription("This is the band room.");
            setState("First",true);
            addItem(new Vibraphone());
            setDark(true);
    }
    
    public void interact(Command command, Context context){
            if((command.verb.getTitle().equals("taste") && command.noun.getName().equals("room"))
                    || (command.verb.getTitle().equals("lick") && command.noun.getName().equals("room"))){
                System.out.println("Why would you want to lick the room?"
                        + " People dumped their spit valves out on the floor!");
            }else if(command.verb.getTitle().equals("listen")){
                System.out.println("You faintly hear echos of crying children and poorly played music.");
            }else if(command.verb.getTitle().equals("smell")){
                System.out.println("You smell sweat and pain.");
            }else{
                command.verb.run(command, context);
            }
            
            command.verb.run(command, context);
                
        }
}
