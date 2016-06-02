package areas;

import core.*;
import items.*;
/**
 *
 * @author Samantha
 */
public class Roof extends Area {
    
    public Roof(World containingWorld) {
        super(containingWorld);
        
        setPortal(World.WEST, new Portal(Portal.UNLOCKED, "WomensRestroom"));
        
        setTitle("Roof");
        setInitialDescription("The roof is largely empty. Smatterings of bird " 
                + "poop litter the ground, and an especially large pile rests " 
                + "in front of you. Past the pile is the edge of the roof.");
        setDescription("This is the roof.");
        
        addItem(new Calculator());
        addItem(new KeySecretPassage());
        
    }

    @Override
    public void interact(Command command, Context construct) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
