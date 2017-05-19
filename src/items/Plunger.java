package items;

import core.Item;

public class Plunger extends Item {

    public Plunger() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Plunger")
            .examine("A grimy plunger.")
            .synonym("plunger")
            .smell("...You know what it smells like")
            .taste("Oh God please don't");
    }
}
