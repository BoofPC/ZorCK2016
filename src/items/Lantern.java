package items;

import core.*;

public class Lantern extends Item {

    public Lantern() {
        super();
        this.usage().take(Item.TAKABLE).active(Item.OFF);
        this.name("Lantern").synonym("lantern", "light", "flashlight");
    }

    @Override
    public void interact(final Command command, final Context context) {

    }
}
