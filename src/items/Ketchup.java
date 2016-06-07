package items;

import core.*;

public class Ketchup extends Item{

    public Ketchup(){
        super();
        this.usage().take(Item.TAKABLE).food(Item.EDIBLE);
        this.name("Ketchup")
            .description("It's a glass bottle of Heins")
            .synonym("mustard", "relish", "red sauce")
            .taste("It's salty but why did you eat plain ketchup?")
            .smell("I bet it would smell great on a burger");
    }
}
