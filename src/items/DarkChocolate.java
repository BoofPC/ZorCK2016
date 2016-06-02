package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class DarkChocolate extends Item{
    
    public DarkChocolate(){
        super();
        setUsageKey(Item.TAKE,1);
        setUsageKey(Item.EAT,2);
        setName("Dark Chocolate");
        setDescription("Its looks dark and tasty");
        addSynonym("dark chocolate");
        addSynonym("chocolate");
        addSynonym("chocolate bar");
        setTaste("It tastes like heaven");
    }
}
