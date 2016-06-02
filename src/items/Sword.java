package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class Sword extends Item{
    
    public Sword(){
        super();
        setUsageKey(Item.TAKE,1);
        setName("Elvish Sword");
        addSynonym("elvish sword");
        addSynonym("sword");
    }
}
