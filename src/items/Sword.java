package items;

import core.*;

public class Sword extends Item{
    
    public Sword(){
        super();
        setUsageKey(Item.TAKE,1);
        setName("Elvish Sword");
        addSynonym("elvish sword");
        addSynonym("sword");
    }
    
    public void interact(Command command, Context context){
        
    }
}
