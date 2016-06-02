package items;

import core.*;
/**
 * This is a special item needed to complete the game.
 * @author Samantha
 */
public class Calculator extends Item {
    
    public Calculator() {
        super();
        setUsageKey(Item.TAKE, 1);
        //turned off by default
        setUsageKey(Item.TURN_ON, 2);
        //TODO: make the calculator do something when it's on
        
        setName("Calculator");
        addSynonym("calculator");
        addSynonym("graphing calculator");
        setDescription("It's a TI-84 Plus Supreme Deluxe Color Limited Edition " 
                + "Graphing Calculator with a 4K touchscreen!");
    }
    
    public void interact(Command command, Context context){
        
    }
}
