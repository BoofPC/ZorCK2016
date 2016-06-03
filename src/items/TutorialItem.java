package items;

import core.*;

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
        this.usage()
            .take(Usage.Take.TAKABLE) // This key means the player can pick out the item
            .food(Usage.Food.EDIBLE); // This key means the player can eat the item
        // TODO Update usage description
        //Full explanation of usage keys can be found at the bottom

        this.setName("Potato Chip");   //This is the item's name, in this case, it is
                             //a banana. This should be a unique name, as, in
                             //the event of a conflict of synonyms, the game
                             //will ask to distinguish between two names
                             //For Example - if the player has both White
                             //Chocolate and Dark Chocolate, and inputs "eat
                             //chocolate," the game will output, "Did you mean
                             //the White Chocolate or the Dark Chocolate?"

        this.setDescription("It looks crunchy and yellow");    //If you want to set
                            //a (visual) description, do so here

        //The synonyms list should include all possible things the user could
        //call the item. All should be lower case and the first item should
        //Always be the name of the item, set above
        this.addSynonym("potato chip");
        this.addSynonym("chip");
        this.addSynonym("crisp");
        this.addSynonym("potato crisp");

        this.setTaste("It tastes greasy and fattening. Delicious!");   //If you want,
        this.setSmell("It smells decadent"); //set additional descriptors here

        //Other possible descriptors:
        //setInside(Item)       -       if another item is inside this one,
        //                              e.g. a bottle of water
        //setText(String)       -       if the item can be read
        //                              e.g. a note
        //setActive(boolean)    -       if the item can be turned on/off
        //                              e.g. a lantern
        //setSound(String)      -       if the item can be heard


    }

    @Override
    public void interact(final Command command, final Context context){

    }

}

        //usage is an array of ints which determines many
        //characteristics of an item. Each item in the
        //array corresponds with an attribute of the item
        //for example the first item in the array represents
        //whether the item is takable, with different numbers
        //as different statuses. 0 is always "unset." 1 is "takable," the user can
        //"take" the item to get it into their inventory. 2 means the item is too
        //heavy to take, and will return an appropriate message if "take (item)"
        //is invoked. 3 means the item is bolted down, etc.
        //
        //The meanings of each item is as follows:
        //{0      ,1   ,2  ,3    ,4   ,5   ,6   ,7     ,8   ,9   ,10   ,11  ,12   ,13   ,14
        //{[dummy],take,eat,drink,open,lock,read,turnOn,move,wear,close,stab,press,climb,receive}
        //feel free to add more
        //the possible statuses of each are as follows:
        //take (n = 1) -    0: unset (default, returns "not takable")
        //                  1: takable
        //                  2: too heavy
        //                  3: bolted down
        //eat (n = 2) -     0: unset (default, returns "not eatable")
        //                  1: not eatable
        //                  2: eatable
        //drink (n = 3) -   0: unset (default, returns "not drinkable")
        //                  1: not drinkable
        //                  2: drinkable
        //                  3: "You need to open it first!"
        //                  4: drinkable, already drank
        //open (n = 4) -    0: unset (default, returns "not openable")
        //                  1: not openable
        //                  2: openable, closed
        //                  3: openable, open
        //lock (n = 5) -    0: unset {default, returns "not lockable")
        //                  1: not lockable
        //                  2: lockable, unlocked
        //                  3: lockable, locked
        //read (n = 6) -    0: unset (default, returns "not readable")
        //                  1: not readable
        //                  2: readable
        //                  3: illegible
        //turnOn (n = 7) -  0: unset (default, returns "not turnOnable")
        //                  1: not turnOnable
        //                  2: turnOnable, off
        //                  3: turnOnable, on
        //move (n = 8) -    0: unset (default, returns "not movable")
        //                  1: unmovable
        //                  2: movable
        //wear (n = 9) -    0: unset (default, returns "not wearable")
        //                  1: unwearable
        //                  2: wearable
        //close (n = 10) -  0: unset (default, returns "not closeable")
        //                  1: not closable
        //                  2: closable, open
        //                  3: closable, closed
        //stab (n = 11) -   0: unset (default, returns "not stabable")
        //                  1: not stabable
        //                  2: stabable
        //press (n = 12) -  0: unset (default, returns "not pressable")
        //                  1: not pressable
        //                  2: pressable, unpressed
        //                  3: pressable, pressed
        //climb (n = 13) -  0: unset (default, returns "not climbable")
        //                  1: not climbable
        //                  2: climbable
        //receive (n = 14) -0: unset (default, returns "cannot receive")
        //                  1: cannot receive items
        //                  2: can recieve items
        //break (n = 15) -  0: unset (default, returns "cannot break")
        //                  1: cannot break item
        //                  2: breakable
        //
        //
        //the first item, represented here as [duumy], refers to
        //whether the item is a real, tangible, and distinct
        //object which should be described when "look" is called
        //(e.g. a screwdriver) or an item which should be hidden
        //unless interacted with (e.g. a pocket on a gown
        //[dummy] -     0: unset (default, returns "real")
        //              1: real
        //              2: not real
        //You can use these variables in place of the first number in setUsageKey()
        //and in place of the number in getUsageKey() to make things more readable
            //Item.TAKE =      1;
            //Item.EAT =       2;
            //Item.DRINK =     3;
            //Item.OPEN =      4;
            //Item.LOCK =      5;
            //Item.READ =      6;
            //Item.TURN_ON =   7;
            //Item.MOVE =      8;
            //Item.WEAR =      9;
            //Item.CLOSE =     10;
            //Item.STAB =      11;
            //Item.PRESS =     12;
            //Item.CLIMB =     13;
            //Item.RECEIVE =   14;
            //Item.BREAK =     15;