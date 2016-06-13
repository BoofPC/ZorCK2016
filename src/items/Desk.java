package items;

import core.*;

/**
 *
 * @author coons5457w
 */

public class Desk extends Item{
    
    public Desk (){
        super();
        this.usage().can_sit(Item.CAN_SIT);
        this.name("Desk")
            .synonym("desk", "table", "chair", "desk chair")
            .examine("You can sit in it.")
            .taste("You chew away on gum on the bottom of the seats. Delicious!")
            .smell("It's a desk, what did you expect?")
            .sound("It's a desk, what did you expect?");
    }
}
