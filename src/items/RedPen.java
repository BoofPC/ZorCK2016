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
 * @author place2849t
 */
public class RedPen extends Item {
    
    public RedPen(){
        super();
        this.usage()
            .take(Item.TAKABLE);
        this.name("Red pen")
        .synonym("pen");
    }
    
}
