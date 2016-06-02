package items;

import core.*;

/**
 * This is a fake item so that Game's nounParser can determine whether there
 * is no item given (which will return this item) or whether the user inputed
 * a nonexistent item (which will return null)
 */

public class NoItem extends Item{
    
    public NoItem(){
        super();
        setName("noItem");
        setUsageKey(0,2);
    }
    
    public void interact(Command command, Context context){
        
    }
}
