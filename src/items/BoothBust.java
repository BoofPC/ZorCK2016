package items;

import core.Item;
/**
 *
 * @author Samantha
 */
public class BoothBust extends Item {
    
    public BoothBust() {
        super();
        
        //cannot pick up
        
        setName("Booth Bust");
        addSynonym("booth bust");
        addSynonym("bust");
        addSynonym("statue");
        addSynonym("bust of booth");
        
        setDescription("It's a well-made bronze likeness of Mr. Booth.");
    }
}
