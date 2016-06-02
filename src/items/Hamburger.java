package items;

import core.*;

/**
 *
 * @author pedro
 */
public class Hamburger extends Item{
    
    public Hamburger(){
        super();
        setUsageKey(Item.TAKE,1);
        setUsageKey(Item.EAT,2);
        setName("Hamburger");
        setDescription("Its meat looks succulent and buns look fluffy");
        addSynonym("hamburger");
        addSynonym("burger");
        addSynonym("cheeseburger");
        setTaste("It is the best burger you've ever tasted");
        setSmell("It smells decadent");
    }
    
    public void interact(Command command, Context context){
        
    }
}
