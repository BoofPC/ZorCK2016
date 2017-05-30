package items;

import core.Item;

/* This is an item found in the Center Room that
*  makes the room not dark. This is an example of
*  an object that can't be taken and an item that
*  affects the room that it's in. See CenterRoom
*  for information on how it affects the room. */
public class Lamp extends Item {

    public Lamp() {
        super();

        /* This is how you specify characteristics
         * of an object, such as whether or not it
         * can be taken by the player, or whether
         * or not it is currently turned on.*/
        this.usage().take(Item.BOLTED_DOWN).active(Item.OFF);

        /* This is the official name of the item.
        *  Players can refer to the item by this. */
        this.name("Lamp")
                /* These are synonyms for the item.
                *  Players can also call the item
                *  by these names. */
                .synonym("lamp", "light", "lights")
                /* When the player chooses to closely
                * examine this item, this is what is
                * shown. By default, this reads "It
                * looks like any other [item_name]
                * you've seen. */
                .examine("It's a very simple lamp with" +
                        "a switch on the base.");
    }
}
