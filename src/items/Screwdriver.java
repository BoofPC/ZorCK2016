package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class Screwdriver extends Item{
    
    public Screwdriver(){
        super();
        setUsageKey(Item.TAKE,1);
        setName("Flathead Screwdriver");
        addSynonym("flathead screwdriver");
        addSynonym("screwdriver");
    }
}
