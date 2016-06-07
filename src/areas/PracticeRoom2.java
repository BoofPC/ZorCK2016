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
        setPortal(World.NORTH, new Portal(false, "CrampedHall"));
        setTitle("Second Practice Room");
            setInitialDescription("This is the second practice room, with a doorway "
                    + "leading north. A cupboard stands against the east wall, but"
                    + " the place looks ransacked.");
            setDescription("This is the second practice room.");
            setState("First",true);
            addItem(new Cupboard());
            setDark(true);
    }
    
    public void interact(Command command, Context context){
            if((command.verb.getTitle().equals("taste") && command.noun.getName().equals("room"))
                    || (command.verb.getTitle().equals("lick") && command.noun.getName().equals("room"))){
                System.out.println("Why would you want to lick the room?"
                        + " People dumped their spit valves out on the floor!");
            }else if(command.verb.getTitle().equals("listen")){
                System.out.println("You hear the echos of your breathing.");
            }else if(command.verb.getTitle().equals("smell")){
                System.out.println("You smell old sweat.");
            }else{
                command.verb.run(command, context);
            }
            
            command.verb.run(command, context);
                
        }
}
