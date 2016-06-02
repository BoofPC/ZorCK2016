package items;

import core.Item;
/**
 * Located on Roof.
 * @author Samantha
 */
public class Crow extends Item {
    
    public Crow() {
        super();
        setName("Crow");
        addSynonym("crow");
        addSynonym("Bird");
        addSynonym("bird");
        
        setDescription("It's a crow with a key tied to it's leg. It turns "
                + "aggressive when you try to take it.");
    }
}
