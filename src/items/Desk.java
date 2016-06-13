package items;

import core.*;

/**
 *
 * @author coons5457w
 */

public class Desk extends Item{
    
    public Desk (){
        super();
        this.usage()
            .can_sit(Item.CAN_SIT)
            .take(Item.TOO_HEAVY);
        this.name("Desk")
            .synonym("desk", "table", "chair", "desk chair")
            .examine("A desk. People sit in it.")
            .taste("You chew away on gum on the bottom of the seats. Delicious!")
            .smell("It's a desk, what did you expect?")
            .sound("Ahh, the sound of desk.\n"
                + "Music to my ears.");
    }
}
