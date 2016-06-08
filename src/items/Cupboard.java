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
public class Cupboard extends Item{
    
    public Cupboard(){
        super();
        this.usage().take(Item.BOLTED_DOWN).open(Item.CLOSED);
        this.name("Cupboard")
        .synonym("cupboard")
        .synonym("cabinet")
        .synonym("Cabinet")
        .description("A cupboard with potentially possible potential.")
        .inside(new MagicOrb());
    }
    
    @Override
    public void interact(final Command command, final Context context){

    }
}
