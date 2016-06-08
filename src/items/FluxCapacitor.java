package items;

import core.*;

public class FluxCapacitor extends Item {

    public FluxCapacitor() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Flux Capacitor").synonym("flux capacitor")
                .examine("This is one of the parts of the time machine!");

    }
}
