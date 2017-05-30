package items;

import core.Item;

/* This item is found in the East Room. It's special, because
 * it is an example of an Item that contains other items. Inside,
 * the player will find a key. */
public class TreasureChest extends Item {

    /* See Lamp for more detailed information about how Items work. */
    public TreasureChest() {
        super();
        this.usage()
                /* If the player tries to take this item,
                *  they will be told that it is too heavy.*/
                .take(Item.TOO_HEAVY)
                /* This is an item that can be opened. It
                *  is closed by default. */
                .open(Item.CLOSED);
        this.name("Treasure Chest")
                .synonym("treasure chest")
                .synonym("chest")
                .synonym("box");
        /* These items are inside the treasure chest.
        *  Note that items can only contain a single
        *  item at most. */
        this.inside(new Key.NorthDoor());
    }
}
