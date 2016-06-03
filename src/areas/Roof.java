package areas;

import core.*;
import items.*;

/**
 * This area contains two important items: the Calculator and a key to the
 * Secret Passage. To get the key, the player must give the crow the cracker
 * (found in Hallway7).
 */
public class Roof extends Area {
    
    public Roof(World containingWorld) {
        super(containingWorld);
        
        getPortals().west(new Portal(Portal.UNLOCKED, "WomensRestroom"));
        
        setTitle("Roof");
        setInitialDescription("The roof is largely empty. Smatterings of bird " 
                + "poop litter the ground, and amongst the poop lies a " 
                + "calculator. An agitated crow is perched atop a bronze bust of " 
                + "Mr. Booth. Past the crow is the edge of the roof. To the " 
                + "west is a window leading to the Women's Restroom.");
        //TODO: add a verb to jump off of the roof
        setDescription("This is the roof.");
        
        setSound("The only sound you hear is the caws of the crow.");
        setSmell("It smells like nothing here is going to further your progress"
                + " in the game!");
        
        addItem(new BoothBust());
        addItem(new Calculator());
        addItem(new Crow());
    }

    @Override
    public void interact(Command command, Context context) {
        String verb = command.getVerb().getTitle();
        String noun = command.getNoun().getName();
        
        if (verb.equals("take")) {
            if (noun.equals("Key to Secret Passage")) {
                System.out.println("The crow is alarmed and pecks you!");
                System.out.println("It looks a little bit hungry...");
                context.getPlayer().addHp(-1);
            }
        } else if (verb.equals("give")) {
            if (noun.equals("Cracker")) {
                command.getVerb().run(command, context);
                System.out.println("The crow seems happy now. It gives you the " 
                        + "key.");
                context.getPlayer().addItem(new Key("Key to Secret Passage",
                        "It's a simple-looking key attached to a keychain with " 
                                +" a label that reads 'Secret Passage'"));
            }
        } else {
            if(command.getNoun() !=  null)
                command.getNoun().interact(command,context);
            if(!context.getSkipGeneral())
                command.getVerb().run(command, context);
        }
    }
}
