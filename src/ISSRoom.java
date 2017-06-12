
import tbge.Area;
import tbge.Context;
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
    private String laterDescription = "A messy room where troubled children stay.\n";
    private String itemDescription = "There is a sword on a large desk in the west of the room.\n";
    private boolean takeSword = false;
            
    public ISSRoom(){
        super("ISS Room");
        this.getDoors().put(Direction.NORTH,new Door("Hallway 9"));
        this.getInventory().add("sword");
        
        this.description = "There are papers scattered throughout the floor."
            + "\nThere is a large desk in the west of the room that has a Sword on it?"
            + "\nDid someone seriously bring that to school? Probably got confiscated," 
            + "\nbut maybe you can use it?"; 

        this.getLocalActions().put(new VerbPhrase("take","sword"),(c)->{
            System.out.println("You take the sword. Be sure to not get caught with that.");
            if(this.getInventory().remove("sword")){
                ((ZorCK)(c.getGame())).addPoints(10);
                c.getPlayer().getInventory().add("sword");
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
        
        this.getLocalActions().put(new VerbPhrase("look"), (c)->{
            System.out.println(description);
            if(takeSword == false){
                description = laterDescription + itemDescription;
            } else {
                description = laterDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
