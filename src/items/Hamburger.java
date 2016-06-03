package items;

import core.*;

public class Hamburger extends Item{

    public Hamburger(){
        super();
        this.usage().take(Usage.Take.TAKABLE).food(Usage.Food.EDIBLE);
        this.name("Hamburger");
        this.description("Its meat looks succulent and buns look fluffy");
        this.synonym("hamburger");
        this.synonym("burger");
        this.synonym("cheeseburger");
        this.taste("It is the best burger you've ever tasted");
        this.smell("It smells decadent");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
