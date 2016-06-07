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
public class Grass extends Item{
    
    public Grass() {
        super();
        this.usage().take(Item.TOO_HEAVY)
            .recieve(Item.RECIEVE);
        this.name("Grass").description("Some grass in a small planter..")
                .synonym("gras", "grass").smell("MM.. smells great");
        this.key(new Scissors().name());
        
        
    }
        
    @Override
    public void interact(final Command command, final Context context){

    }
    
    }
    
    