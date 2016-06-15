/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import core.*;

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
        .examine("A cupboard with potentially possible potential.")
        .inside(new MagicOrb());
    }
}
