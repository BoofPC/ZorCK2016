package items;

import core.*;

/**
 *
 * @author pedro
 */
public class Lantern extends Item{
    
    public Lantern(){
        super();
        setUsageKey(Item.TAKE,1);
        setUsageKey(Item.TURN_ON,2);
        setName("Lantern");
        addSynonym("lantern");
        addSynonym("light");
        addSynonym("flashlight");
        
    }
    
    public void interact(Command command, Context context){
        
    }
}
