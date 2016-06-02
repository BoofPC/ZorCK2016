package items;

import core.*;

public class WhiteChocolate extends Item{
    
    public WhiteChocolate(){
        super();
        setUsageKey(Item.TAKE,1);
        setUsageKey(Item.EAT,2);
        setName("White Chocolate");
        setDescription("Its looks light and disgusting");
        addSynonym("white chocolate");
        addSynonym("chocolate");
        addSynonym("chocolate bar");
        setTaste("It tastes like hell");
    }
    
    public void interact(Command command, Context context){
        
    }
}
