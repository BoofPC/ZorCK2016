package items;

import core.Item;
/**
 *
 * @author Alex Johnson
 */
public class FluxCapacitor extends Item{
    
    public FluxCapacitor(){
        super();
        setUsageKey(Item.TAKE, 1);
        setName("Flux Capacitor");
        addSynonym("flux capacitor");
        setDescription("This is one of the parts of the time"
                + " machine!");
        
    }
}
