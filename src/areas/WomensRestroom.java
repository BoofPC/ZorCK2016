package areas;

import core.*;
import items.*;
import verbs.Verbs.Read;
/**
 * This area has a window that leads to the roof. There's nothing else here,
 * except for a poster on the door of a stall.
 * @author Samantha
 */
public class WomensRestroom extends Area {

    public WomensRestroom(World containingWorld) {
        super(containingWorld);
        
        //TODO: add way to unlock portal by opening window
        setPortal(World.EAST, new Portal(Portal.LOCKED, "Roof"));
        setPortal(World.SOUTH, new Portal(Portal.UNLOCKED, "Hallway7"));
        
        setTitle("Women's Restroom");
        setInitialDescription("The room is dimly lit, illuminated only by the "
                + "light coming in from the window to the east. To the south "
                + "is a doorway leading into the hallway. A poster hangs on "
                + "the door of one of the stalls.");
        setDescription("This is the Women's Restroom.");
        
        setSound("You hear an incessant dripping sound coming from a faucet.");
        setSmell("It smells like flowers.");
        
        addItem(new AdamsonPoster());
        
    }
    
    @Override
    public void interact(Command command, Context context) {
        String verb = command.getVerb().getTitle();
        String noun = command.getNoun().getName();
        
        //read the poster, in case the player looks at it instead
        if (verb.equals("examine") && noun.equals("Adamson Poster")) {
            new Read().run(command, context);
        } else {
            if(command.getNoun() !=  null)
                command.getNoun().interact(command,context);
            if(!context.getSkipGeneral())
                command.getVerb().run(command, context);
        }
    }
    
}
