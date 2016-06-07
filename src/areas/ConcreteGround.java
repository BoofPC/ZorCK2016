package areas;

import core.*;
/**
 * This area is reached by walking off of the roof. If you are in this room, 
 * that means that you fell. You die.
 */

public class ConcreteGround extends Area {
    
    public ConcreteGround(final World containingWorld) {
        super(containingWorld);
    }
    
    @Override
    public void enter(final Player player) {
        //if someone else ends up using this room, 
        //they can make this line more generic
        System.out.println("You walked off of the roof.");
        player.getDeath();
    }
}
