package items;

import core.Item;

/* This item is found inside of the Treasure Chest
*  in the East Room. It is an example of an edible
*  item. */
public class Muffin extends Item {

    /* See Lamp for more details about how Items work. */
    public Muffin() {
        super();

        this.usage()
                .take(Item.TAKABLE)
                .food(Item.EDIBLE);
        this.name("Muffin")
                .synonym("muffin")
                .examine("It is a freshly-baked chocolate muffin!")
                .taste("It tastes delicious.")
                .smell("The smell makes your mouth water.");
    }
}
