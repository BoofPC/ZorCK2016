package items;

import core.*;

public class Kiddies extends Item{

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
