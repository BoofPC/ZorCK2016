package items;

import core.Item;

/* This item doesn't do anything. The only purpose it serves
*  is to have its name printed when the North Room prints out
*  the list of its contents. */
public class Troll extends Item {

    public Troll() {
        super();

        this.usage().take(Item.UNTAKABLE);
        this.name("Hungry Troll")
                .synonym("troll")
                .examine("You can only see it's glowing yellow eyes.");
    }
}
