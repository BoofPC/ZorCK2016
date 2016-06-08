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
public class Motor extends Item{
    
    public Motor(){
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Motor")
        .synonym("motor")
        .description("A greasy motor, with a battery pack attached. Someone"
                + " was very clever a long time ago, though you have no idea"
                + " how the batteries still work. It must be Black Magic.");
    }
    
    @Override
    public void interact(final Command command, final Context context){

    }
}
