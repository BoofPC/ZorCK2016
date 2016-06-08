/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import core.*;
/**
 *
 * @author johnson5951a
 */
public class Chemical extends Item{
    
    public Chemical(){
        super();
        this.name("Chemical")
            .look("It is green and nasty looking. It bubbles.")
            .synonym("chemical", "chemicals")
            .smell("It smells absolutely horrid. Like, worse than the Super Mario Bros. movie horrid.")
            .taste("It tastes exactly like Sprite.")
            .read("Do Not Ingest!");
    }
    
    @Override
    public boolean interact(final Command command, final Context context){
        String verb = command.getVerb().getTitle();
        String noun = command.getNoun().name();
        final Player player = context.getPlayer();
        
        if(verb.equals("drink")){
            switch(noun){
                case "Chemical":
                    System.out.println("I warned you.");
                    player.setDeath(Game.Status.SUICIDE);
                    break;
                    
                default:
                    System.out.println("I'm not exactly sure what you're trying to drink.");
            }
            return true;
        }
        
        else if(verb.equals("drop")){
            switch(noun){
                case "Chemical":
                    System.out.println("The green slimy substance kills you upon its descent to the ground.");
                    player.setDeath(Game.Status.DIE);
                    break;
                    
                default:
                    super.interact(command, context);
                    
            }
            return true;
            
        }
        
        return false;
    }
}
