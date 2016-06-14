package items;

import core.*;

/**
 *
 * @author coons5457w
 */

public class MrFitz extends Item{
    
    public MrFitz(){
        super();
        this.usage().talk(Item.TALK);
        this.name("Mr. Fitz")
            .synonym("Mr. Fitz", "mr fitz", "fitz", "teacher", "man", "guy", "math teacher", "mathteacher")
            .examine("This is Mr. Fitz. He's drinking coffee and he's staring into"
                + " your soul. 'Sup?', he says, making the situation even more awkward.")
            .taste("You can't taste a person!")
            .smell("Smells like coffee.")
            .sound("Mr. Fitz is slurping his coffee.");     
    }
}
