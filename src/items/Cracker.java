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
        
        setName("Cracker");
        addSynonym("cracker");
        
        setDescription("It's a stale cracker.");
    }
}
