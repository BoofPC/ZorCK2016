/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Room: PracticeRoom1
// North: CrampedHall1
// East: wall
// West: wall
// South: wall
// Initial Description: Tattered carpet hands from the walls, and a piano stands languishing in the corner. A door leads to the north.
// Description: This is the first practice room
// Dark?: True
// Smell: You smell broken dreams floating through the air.
// Sound: You hear the sound of a forlorn oboe trying to succeed in life.
// Taste: Why would you want to lick the room? People dumped their spit valves out on the floor!
// Special States: n/a
// Items in room: Piano
package areas;
import core.*;
import items.*;

/**
 *
 * @author flowers9695r
 */
public class PracticeRoom1 extends Area{
    
    public PracticeRoom1(World containingWorld){
        super(containingWorld);
        setPortal(World.NORTH, new Portal(false, "CrampedHall"));
        setTitle("First Practice Room");
            setInitialDescription("This is the first practice room, with a doorway "
                    + "leading north. Tattered carpet hangs from the walls, and"
                    + " a piano stands languishing in the corner.");
            setDescription("This is the first practice room.");
            setState("First",true);
            addItem(new Piano());
            setDark(true);
    }
    
    public void interact(Command command, Context context){
            if((command.verb.getTitle().equals("taste") && command.noun.getName().equals("room"))
                    || (command.verb.getTitle().equals("lick") && command.noun.getName().equals("room"))){
                System.out.println("Why would you want to lick the room?"
                        + " People dumped their spit valves out on the floor!");
            }else if(command.verb.getTitle().equals("listen")){
                System.out.println("You faintly hear the sound of a forlorn"
                        + " oboe trying to succeed in life.");
            }else if(command.verb.getTitle().equals("smell")){
                System.out.println("You smell broken dreams floating through the air.");
            }else{
                command.verb.run(command, context);
            }
            
            command.verb.run(command, context);
                
        }
}
