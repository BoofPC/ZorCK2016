package items;

import core.*;

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

    public static class Adamsons extends Key {
        public Adamsons() {
            super("Adamson's Key", "A key to Adamson's room");
        }
    }

    public static class Library extends Key {
        public Library() {
            super("Library Key", "A key to the library");
        }
    }

    public static class SecretPassage extends Key {
        public SecretPassage() {
            super("Secret Passage Key", "A dank key to the secret passage");
        }
    }

    public static class StaffLounge extends Key {
        public StaffLounge() {
            super("Staff Lounge Key", "A key to the staff lounge");
        }
    }

    public static class Toolbox extends Key {
        public Toolbox() {
            super("Toolbox Key", "A key to the toolbox");
        }
    }
}
