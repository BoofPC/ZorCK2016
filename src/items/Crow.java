package items;

import core.*;

/**
 * Located on Roof.
 */
public class Crow extends Item {

    public Crow() {
        super();
        this.usage().recieve(Usage.Recieve.RECIEVE);

        this.name("Crow")
            .synonym("crow")
            .synonym("bird")

            .description("It's a crow with a key tied to it's leg. It turns "
                + "aggressive when you try to take it.");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
