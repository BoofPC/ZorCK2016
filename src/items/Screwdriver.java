package items;

import core.*;

public class Screwdriver extends Item{
    
    public Screwdriver(){
        super();
        setUsageKey(Item.TAKE,1);
        setName("Flathead Screwdriver");
        addSynonym("flathead screwdriver");
        addSynonym("screwdriver");
    }
    
    public void interact(Command command, Context context){
        
    }
}
