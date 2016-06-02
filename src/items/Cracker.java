package items;

import core.*;
/**
 * 
 * @author Samantha
 */
public class Cracker extends Item {
    
    public Cracker() {
        super();
        setUsageKey(Item.TAKE, 1);
        setUsageKey(Item.EAT, 2);
        //can't break it. it's an indestructable cracker!
        
        setName("Cracker");
        addSynonym("cracker");
        
        setDescription("It's a stale cracker.");
        
        setTaste("It tastes slightly salty, with a hint of carpet.");
    }
    
    public void interact(Command command, Context context){
        
    }
}
