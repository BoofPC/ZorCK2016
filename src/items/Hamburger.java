package items;

import core.*;

public class Hamburger extends Item{

    public Hamburger(){
        super();
        this.setUsageKey(Item.TAKE,1);
        this.setUsageKey(Item.EAT,2);
        this.setName("Hamburger");
        this.setDescription("Its meat looks succulent and buns look fluffy");
        this.addSynonym("hamburger");
        this.addSynonym("burger");
        this.addSynonym("cheeseburger");
        this.setTaste("It is the best burger you've ever tasted");
        this.setSmell("It smells decadent");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
