/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;
import core.Item;
/**
 *
 * @author Alex Johnson
 */
public class FluxCapacitor extends Item{
    public FluxCapacitor(){
        super();
        setUsageKey(1, 1);
        setName("Flux Capacitor");
        addSynonym("flux capacitor");
        setDescription("This is one of the parts of the time"
                + " machine!");
        
    }
}
