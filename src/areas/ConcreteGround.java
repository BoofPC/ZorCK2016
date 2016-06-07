package areas;

import core.*;
/**
 * This area is reached by walking off of the roof. If the player is here, that 
 * means that they fell to their death.
 */

public class ConcreteGround extends Area {
    
    public ConcreteGround(final World containingWorld) {
        super(containingWorld);
    }
    
    @Override
    public void enter(final Player player) {
        player.getDeath();
    }
}
