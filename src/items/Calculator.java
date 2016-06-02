package items;

import core.Item;
/**
 * This is a special item needed to complete the game.
 * @author Samantha
 */
public class Calculator extends Item {
    
    public Calculator() {
        super();
        //can take
        setUsageKey(1, 1);
        //can turn on, off by default
        setUsageKey(7, 2);
        
        setName("Calculator");
        addSynonym("calculator");
        addSynonym("graphing calculator");
        setDescription("It's a TI-84 Plus Supreme Deluxe Color Limited Edition " 
                + "Graphing Calculator with a 4K touchscreen!");
    }
}
