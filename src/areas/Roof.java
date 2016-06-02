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
        //With the new Key() class, you should be able to just use
        //Item keySecretPassage = new Key("Key to Secret Passage","It's a 
        //      simple looking key attached to a keychain with a label that 
        //      reads 'Secret Passage'");
        //keySecretPassage.addSynonym("secret passage key")
        //addItem(keySecretPassage);
        //
        //But I haven't tested any of that yet
        
    }

    @Override
    public void interact(Command command, Context construct) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
