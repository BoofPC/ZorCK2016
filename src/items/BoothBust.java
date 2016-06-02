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
        addSynonym("Statue");
        addSynonym("statue");
        addSynonym("bust of booth");
        addSynonym("Bust of Booth");
        
        setDescription("It's a well-made bronze likeness of Mr. Booth.");
    }
}
