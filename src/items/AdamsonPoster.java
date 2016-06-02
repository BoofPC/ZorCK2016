package items;

import core.Item;
/**
 * This is an ASCII art poster of Adamson. To view the image, the player must
 * read the poster.
 * @author Samantha
 */
public class AdamsonPoster extends Item {
    
    public AdamsonPoster() {
        super();
        //can take
        setUsageKey(1, 1);
        //can read
        setUsageKey(6, 2);
        
        setName("Adamson Poster");
        addSynonym("poster");
        addSynonym("flier");
        addSynonym("picture");
        setDescription("It is the most beautiful image you have ever laid your"
                + "eyes upon.");
    }
}
