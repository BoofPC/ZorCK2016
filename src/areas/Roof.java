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
                + "poop litter the ground, and amongst the poop lies a " 
                + "calculator. An agitated crow is perched atop a bronze bust of " 
                + "Mr. Booth. Past the crow is the edge of the roof.");
        setDescription("This is the roof.");
        
        setSound("The only sound you hear is the caws of the crow.");
        setSmell("It smells delicious.");
        
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
            command.getVerb().run(command, context);
        }
    }
}
