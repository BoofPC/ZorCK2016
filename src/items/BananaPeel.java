package items;

import core.*;

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
    
    public void interact(Command command, Context context){
        
    }
}
