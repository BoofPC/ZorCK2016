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
        // The object can be taken
        this.setUsageKey(Item.TAKE,1);
        this.setName("Magic Orb");
        this.addSynonym("magic orb");
        this.addSynonym("orb");
        this.addSynonym("magic ball");
        this.setDescription("It looks like it would do something special if "
                + "you took it");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
