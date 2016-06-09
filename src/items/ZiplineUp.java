/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import areas.Roof;
import core.Command;
import core.Context;
import core.Item;
import core.Portal;

/**
 *
 * @author flowers9695r
 */
public class ZiplineUp extends Item{

    public ZiplineUp(final boolean locked){
        super();
        this.usage().take(Item.BOLTED_DOWN).open(Item.CLOSED);
        this.usage().lock(Item.LOCKED);
        this.name("Steep Zipline")
            .description("You gotta find some way to get up it!")
            .synonym("steep zipline")
            .synonym("zipline")
            .key("Motor")
            .portal(new Portal(true, Roof.class));
    }

    @Override
    public void interact(final Command command, final Context context){
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();
        
        if((verb.equals("attach") || verb.equals("place")) && noun.equals("motor")){
            System.out.println("The motor attaches to the zipline like that was"
                    + " the intended purpose. Kinda strange. You could probably go up now.");
           context.getPlayer().removeItem(context.getPlayer().getItem("Motor"));
           this.usage().lock(Item.UNLOCKED);
           this.name("Zipline")
               .description("That zipline looks like fun!");
        }
        
    }
}
