package items;

import core.*;

/**
 * Located on Roof.
 */
public class Crow extends Item {

    public Crow() {
        super();
        this.usage().recieve(Item.RECIEVE);

        this.name("Crow")
            .synonym("crow", "bird")
            .examine("It's a crow with a key tied to it's leg. It turns "
                + "aggressive when you try to take it.");
    }
}
