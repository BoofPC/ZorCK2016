package items;
import core.*;

public class Window extends Door {
    
    public Window(boolean locked, String name, Class<? extends Item> key, Portal portal) {
        super(locked, name, key, portal);
        this.usage().open(Item.CLOSED);
        if (locked) {
            this.usage().lock(Item.LOCKED);
            this.name("Locked Window")
                .synonym("locked window");
        } else {
            this.usage().lock(Item.UNLOCKED);
            this.name("Window")
                .examine("It's a pretty nice window. It looks like it could "
                        + "swing open!");
        }
        if (name != null) {
            this.name(name)
                .synonym(name.toLowerCase());
        }
        this.synonym("window");
        this.key(key)
            .portal(portal);
    }
    
}
