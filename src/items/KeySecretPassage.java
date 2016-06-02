package items;

import core.Item;
/**
 * This key can unlock the Secret Passage to the Library
 * @author Samantha
 */
public class KeySecretPassage extends Item{
    
    public KeySecretPassage() {
        super();
        //can take
        setUsageKey(1, 1);
        
        setName("Key to Secret Passage");
        addSynonym("key to secret passage");
        addSynonym("secret passage key");
        addSynonym("key");
        setDescription("It's a simple looking key attached to a keychain with " 
                + "a label that reads 'Secret Passage'");
    }
}
