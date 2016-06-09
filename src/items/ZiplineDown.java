/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import areas.LandingPad;
import core.Command;
import core.Context;
import core.Item;
import core.Portal;

/**
 *
 * @author flowers9695r
 */
public class ZiplineDown extends Item{

    public ZiplineDown(){
        super();
        this.usage().take(Item.BOLTED_DOWN).open(Item.CLOSED);
        this.name("Zipline")
        .description("That zipline looks like fun!");
        if(name != null){
            this.name(name)
                .synonym(name.toLowerCase());
        }
        this.synonym("zipline")
        .portal(new Portal(true, LandingPad.class));
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
