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
        this.portals().north(new Portal(false, CrampedHall.class));
        this.title("First Practice Room")
        .initialDescription("This is the first practice room, with a doorway "
                    + "leading north. Tattered carpet hangs from the walls, and"
                    + " a piano stands languishing in the corner.")
        .description("This is the first practice room.").state("First",true)
        .item(new Piano()).dark(true);
    }
    
    @Override
    public void interact(final Command command, final Context context){
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();
        
        if((verb.equals("taste") || verb.equals("lick")) && noun.equals("room")){
            System.out.println("Why would you want to lick the room?"
                    + " People dumped their spit valves out on the floor!");
        }else if(verb.equals("listen")){
            System.out.println("You faintly hear the sound of a forlorn"
                    + " oboe trying to succeed in life.");
        }else if(verb.equals("smell")){
            System.out.println("You smell broken dreams floating through the air.");
        }else{
            super.interact(command, context);
        }        
    }
}
