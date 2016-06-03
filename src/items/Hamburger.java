package items;

import core.*;

public class Hamburger extends Item{

    public Hamburger(){
        super();
        this.usage().take(Usage.Take.TAKABLE).food(Usage.Food.EDIBLE);
        this.name("Hamburger")
            .description("Its meat looks succulent and buns look fluffy")
            .synonym("hamburger")
            .synonym("burger")
            .synonym("cheeseburger")
            .taste("It is the best burger you've ever tasted")
            .smell("It smells decadent");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
