import tbge.Area;
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
        this.getDoors().put(Direction.WEST,new Door("Hallway7"));
        this.getInventory().add("SecretPassageKey");
        
        this.description = "The skies are clear, without a single cloud in the sky. The floor seems slightly "
                + "\nslippery and there are no rails to hold onto or to keep people from falling off. Be careful, "
                + "\nthis area was clearly not meant to be walked on. There is a key on the ground, it looks like"
                + "\nit will open up the door to the secret passage behind the library. You should proabably"
                + "\npick it up.";
        
        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            description = laterDescription;
            if(this.getInventory().contains("SecretPassageKey")){
                description += keyDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("east"), (c)->{
            System.out.println("You walk off the roof and fall to the hard concrete ground."
                    + "\nYour skull breaks open on impact, and your brain slowly oozes out"
                    + "\n of your head."
                    + "\nYou Lose");
            c.getGame().quit();
            return !Game.GO_TO_NEXT;
        });

        this.getLocalActions().put(new VerbPhrase("north"), (c)->{
            System.out.println("You walk into the wall, causing you to hit your"
                    + "\nhead and fall to the concrete ground. Your skull breaks"
                    + "\nopen on impact, and your brain slowly oozes out of"
                    + "\nyour head."
                    + "\nYou Lose");
            c.getGame().quit();
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("south"), (c)->{
            System.out.println("You walk off the roof and fall to the hard concrete ground."
                    + "\nYour skull breaks open on impact, and your brain slowly oozes out"
                    + "\n of your head."
                    + "\nYou Lose");
            c.getGame().quit();
            return !Game.GO_TO_NEXT;
        });
    }
}
