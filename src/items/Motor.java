package items;

import core.*;

public class Motor extends Item {
    public Motor() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Motor").synonym("motor")
                .examine("A greasy motor, with a battery pack attached. Someone"
                        + " was very clever a long time ago, though you have no idea"
                        + " how the batteries still work. It must be Black Magic.");
    }
}
