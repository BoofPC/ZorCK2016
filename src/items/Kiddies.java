package items;

import core.*;
/**
 *
 * @author coons5457w
 */
public class Kiddies extends Item{
    
    private boolean ate;
    
    public Kiddies(){
        super();
        this.usage().talk(Item.TALK);
        this.name("kids")
            .synonym("kiddies", "group of kids", "group", "kid")
            .examine("They're eating lunch.")
            .taste("You must feel humiliated now.")
            .smell("Do ever do that again.")
            .sound("Lips smacking.");
    }
}
    