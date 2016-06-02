package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class Lantern extends Item{
    
    public Lantern(){
        super();
        setUsageKey(Item.TAKE,1);
        setUsageKey(Item.TURN_ON,2);
        setName("Lantern");
        addSynonym("lantern");
        addSynonym("light");
        addSynonym("flashlight");
        
    }
}
