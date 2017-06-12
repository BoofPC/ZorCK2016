import tbge.Area;
import tbge.Context;
import tbge.Door;
import tbge.Game;
import tbge.Player;
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
public class Rooftop extends Area{
    private String laterDescription = "An outdoor rooftop with no railing, be careful where you step.";
    private String keyDescription = "There seems to be a key on the ground. You should take it.";
    
    public Rooftop(){
        super("Rooftop");
        this.getDoors().put(Direction.WEST,new Door("Hallway 7"));
        this.getInventory().add("secretpassagekey");
        
        this.description = "The skies are clear, without a single cloud in the sky. The floor seems slightly "
                + "\nslippery and there is a temporary railing to keep people from falling off the edge."
                + "\nThere is a key on the ground, it looks like it will open up the door to the secret passage"
                + "\nbehind the library. You should proabably pick it up.";
        
        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            description = laterDescription;
            if(this.getInventory().contains("secretpassagekey")){
                description += keyDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("look"), (c)->{
            System.out.println(description);
            description = laterDescription;
            if(this.getInventory().contains("secretpassagekey")){
                description += keyDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("take", "secretpassagekey"), (c)->{
            if(this.getInventory().contains("secretpassagekey")){
                System.out.println("You got the secretpassagekey. You should be able to go into the library through the secret passage now.");
                c.getPlayer().getInventory().add("secretpassagekey");
                this.getInventory().remove("secretpassagekey");
            }
            return !Game.GO_TO_NEXT;
            });
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
        
}
