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
public class BananaPeel extends Item{
    public BananaPeel(){
        super();
        setUsageKey(Item.TAKE, 1);
        setUsageKey(Item.MOVE, 2);
        setUsageKey(Item.WEAR, 2);
        setName("Banana Peel");
        setDescription("This is one of the parts of the time"
                + " machine!");
        addSynonym("banana peel");
    }
}
