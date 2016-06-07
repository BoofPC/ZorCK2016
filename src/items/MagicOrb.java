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
 * 
 * TODO Do it here instead
 */
public class MagicOrb extends Item{

    public MagicOrb (){
        super();
        // The object can be taken
        this.usage().take(Item.TAKABLE);
        this.name("Magic Orb")
            .synonym("magic orb", "orb", "magic ball")
            .description("It looks like it would do something special if "
                + "you took it");
    }
}
