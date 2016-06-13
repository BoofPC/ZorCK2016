package items;

import core.*;

/**
 *
 * @author Sonic Duck
 */
public class Assignment extends Item {
    public Assignment(){
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Assignment").synonym("assignment", "my assignment", "the assignment")
        .examine("It's your Japanese homework.")
        .taste("Tastes like paper covered in soy sauce.")
        .smell("Ew, smells like work.")
        .sound("It's not too talkative.");
    }
}
