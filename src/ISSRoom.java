
import tbge.Area;
import tbge.Door;
import tbge.Game;
import tbge.VerbPhrase;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodrigu3163b
 */
public class ISSRoom extends Area{
    private String laterDescription = "A messy room where troubled children stay.";
    private String itemDescription = "There is a Sword on a large desk in the west of the room.";
    private boolean takeSword = false;
            
    public ISSRoom(){
        super("ISS Room");
        this.getDoors().put(Direction.NORTH,new Door("Hallway"));
        this.getInventory().add("Sword");
        
        this.description = "There are papers scattered throughout the floor."
            + "There is a large desk in the west of the room that has a sword on it?" 
            + "Did someone seriously bring that to school? Probably got confiscated," 
            + "but maybe you can use it?"; 

        this.getLocalActions().put(new VerbPhrase("take","Sword"),(c)->{
            description = laterDescription;
            System.out.println("You take the Sword. Be sure to not get caught with that.");
            if(this.getInventory().remove("Sword")){
                c.getPlayer().getInventory().add("Sword");
                takeSword = true;
            } else {
                System.out.println("You already took that!");
            }

            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            if(takeSword == false){
                description = laterDescription + itemDescription;
            } else {
                description = laterDescription;
            }
            return !Game.GO_TO_NEXT;
        });
    }
    
}
