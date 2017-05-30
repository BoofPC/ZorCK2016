package items;

import core.*;

/* Every key in the game extends this class. When you create a locked door,
* you must pass in a Key in the constructor. CenterRoom for an example of a
* locked door. */
public class Key extends Item {
    public Key(final String name, final String description) {
        super();
        this.usage().take(Item.TAKABLE);
        this.name(name);
        if (!name.equals("key")) {
            this.synonym(name.toLowerCase());
        }
        this.synonym("key").examine(description);
    }

    public Key() {
        super();
        this.usage().lock(Item.LOCKED);
        this.name("Key").synonym("key").examine("A small, yellow key");
    }

    public static class NorthDoor extends Key {
        public NorthDoor() {
            super("North Door Key", "A key to the North Door.");
        }
    }
}
