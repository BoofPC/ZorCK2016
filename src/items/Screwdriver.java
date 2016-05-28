/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class Screwdriver extends Item{
    
    public Screwdriver(){
        super();
        setUsageKey(1,1);
        setName("Flathead Screwdriver");
        setDescription("It looks like every other flathead screwdriver you've "
                + "ever seen");
        addSynonym("flathead screwdriver");
        addSynonym("screwdriver");
    }
}
