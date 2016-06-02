package items;

import core.Item;

/**
 *
 * @author Alex Johnson
 */
public class MrFusion extends Item {

    public MrFusion(){
        super();
        setUsageKey(Item.TAKE, 1);
        //not drinkable because you need it for the time machine
        setName("Mr.Fusion");
        setDescription("This is one of the parts of the time"
                + " machine!");
        addSynonym("mr fusion");
        addSynonym("mr. fusion");
    }
}
