package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class NoTea extends Item{
    
    public NoTea(){
        super();
        setName("No Tea");
        setDescription("What? That makes no sense. Pull yourself together!");
        addSynonym("no tea");
    }
}
