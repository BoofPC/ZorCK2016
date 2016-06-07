package items;

import core.*;

public class Hamburger extends Item{

    public Hamburger(){
        super();
        this.usage().take(Item.TAKABLE).food(Item.EDIBLE);
        this.name("Hamburger")
            .description("Its meat looks succulent and buns look fluffy")
            .synonym("hamburger", "burger", "cheeseburger")
            .taste("It is the best burger you've ever tasted")
            .smell("It smells decadent");
    }
}
