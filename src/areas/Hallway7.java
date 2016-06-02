package areas;

import core.*;
import items.*;
/**
 *
 * @author Samantha
 */
public class Hallway7 extends Area {
    
    public Hallway7(World containingWorld) {
        super(containingWorld);
        
        setPortal(World.NORTH, new Portal(Portal.UNLOCKED, "WomensRestroom"));
        setPortal(World.WEST, new Portal(Portal.UNLOCKED, "Hallway8"));
        
        setTitle("Hallway");
        setInitialDescription("This is the end of the hallway. To the north is "
                + "a doorway that leads to the women's restroom. Off to the "
                + "side is a staircase that has been barricaded with chairs. "
                + "The hallway continues to the west. A stale cracker lies in "
                + "the center of the hallway.");
        setDescription("This is the end of the hallway.");
        
        addItem(new Cracker());
    }

    @Override
    public void interact(Command command, Context context) {
        command.getVerb().run(command, context);
    }
}