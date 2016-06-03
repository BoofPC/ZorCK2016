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
        this.setName("noItem");
        this.setUsageKey(0,2);
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
