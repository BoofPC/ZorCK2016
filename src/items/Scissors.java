/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import core.*;

/**
 *
 * @author Kevin White
 */
public class Scissors extends Item{
    
    public Scissors() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Scissors").description("A pair of plastic scissors used to cut frail things")
                .synonym("scissors", "scisors", "scissor")
                .smell("plasticy");
        
    }
    
    @Override
    public void interact(final Command command, final Context context){
    /*        if(command.getVerb().getTitle().equals("run")
                    &&  context.getPlayer().hasMatching(command.getNoun())){
                final Player player = context.getPlayer();
                System.out.println("Running with scissors is a bad idea");
            }
            else {
                command.getVerb().run(command, context);
            }
                 
   */ }
}
