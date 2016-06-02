package items;

import core.Item;
/**
 * 
 * @author Samantha
 */
public class Cracker extends Item {
    
    public Cracker() {
        super();
        //can take
        setUsageKey(1, 1);
        //can eat
        setUsageKey(2, 2);
        //can't break it. it's an indestructable cracker!
        
        setName("Cracker");
        addSynonym("cracker");
        
        setDescription("It's a stale cracker.");
        
        setTaste("It tastes slightly salty, with a hint of carpet.");
    }
}
