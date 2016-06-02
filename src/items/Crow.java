package items;

import core.*;

/**
 * Located on Roof.
 */
public class Crow extends Item {
    
    public Crow() {
        super();
        
        setUsageKey(Item.RECEIVE, 2);
        
        setName("Crow");
        addSynonym("crow");
        addSynonym("bird");
        
        setDescription("It's a crow with a key tied to it's leg. It turns "
                + "aggressive when you try to take it.");
    }
    
    public void interact(Command command, Context context){
        
    }
}
