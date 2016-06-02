package items;

import core.*;

/**
 * This magic orb is special
 * 
 * when the user says "TAKE ORB," instead of putting the orb in the player's
 * inventory, the player will absorb the orb and gain 10 max hp points
 *
 * To do this, we will write a special take method in the Area in which the
 * orb will be (Test8)
 */
public class MagicOrb extends Item{
    
    public MagicOrb (){
        super();
        setUsageKey(Item.TAKE,1);                   //The object can be taken
        setName("Magic Orb");
        addSynonym("magic orb");
        addSynonym("orb");
        addSynonym("magic ball");
        setDescription("It looks like it would do something special if "
                + "you took it");
    }
    
    public void interact(Command command, Context context){
        
    }
}
