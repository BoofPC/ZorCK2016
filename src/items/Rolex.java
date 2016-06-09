/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import core.*;

/**
 *
 * @author White3905k
 */
public class Rolex extends Item {
    
    public Rolex(){
        super();
        this.usage().take(TAKABLE).read(Item.READABLE);
        this.name("Rolex")
                .examine("This looks quite expensive yet completely pointless to you")
                .synonym("watch", "the rolex", "the watch")
                .read("Not much to read")
                .smell("ahhhhhhhh");
    }
}
