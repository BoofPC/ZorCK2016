
package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class TutorialItem extends Item{

    //This is a tutorial to create a unique item.
    //Only use this to create items which will only appear once in the game
    //If you want to make an item that will appear multiple times in the game,
    //(e.g. a Door) please see Peter or Sam
    //
    //In this tutorial, we will be creating a potato chip
    //The actual filename would be PotatoChip.java
    
    public TutorialItem(){
        super();
        setUsageKey(1,1);   //This key means the player can pick out the item
        setUsageKey(2,2);   //This key means the player can eat the item
        //Full explanation of usage keys can be found at the bottom
        
        setName("Potato Chip");   //This is the item's name, in this case, it is
                             //a banana. This should be a unique name, as, in
                             //the event of a conflict of synonyms, the game
                             //will ask to distinguish between two names
                             //For Example - if the player has both White 
                             //Chocolate and Dark Chocolate, and inputs "eat
                             //chocolate," the game will output, "Did you mean
                             //the White Chocolate or the Dark Chocolate?"
                             
        setDescription("It looks crunchy and yellow");    //If you want to set
                            //a (visual) description, do so here
        
        //The synonyms list should include all possible things the user could
        //call the item. All should be lower case and the first item should
        //Always be the name of the item, set above
        addSynonym("potato chip");
        addSynonym("chip");
        addSynonym("crisp");
        addSynonym("potato crisp");
        
        setTaste("It tastes greasy and fattening. Delicious!");   //If you want,
        setSmell("It smells decadent"); //set additional descriptors here
                            //Other possible descriptors:
            //setInside(Item)       -       if another item is inside this one,
            //                              e.g. a bottle of water
            //setText(String)       -       if the item can be read
            //                              e.g. a note
            //setActive(boolean)    -       if the item can be turned on/off
            //                              e.g. a lantern
            //setSound(String)      -       if the item can be heard
    }
}
