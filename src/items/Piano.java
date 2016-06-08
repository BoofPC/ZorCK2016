/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import core.Command;
import core.Context;
import core.Item;

/**
 *
 * @author flowers9695r
 */
public class Piano extends Item{
    
    public Piano(){
        super();
        this.usage().take(Item.TOO_HEAVY);
        
        this.name("Piano")
        .synonym("piano")
        .synonym("keyboard")
        .synonym("Keyboard")
        .description("A very sad piano. It looks like its waiting for its Mozart");
    }
    
    @Override
    public void interact(final Command command, final Context context){

    }
}
