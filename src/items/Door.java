package items;

import core.*;

public class Door extends Item{

    public Door(final boolean locked,final String name,final Class<? extends Item> key,final Portal portal){
        super();
        this.usage().take(Item.BOLTED_DOWN).open(Item.CLOSED);
        if(locked){
            this.usage().lock(Item.LOCKED);
            this.name("Locked Door")
                .examine("You gotta find some way to unlock it!")
                .synonym("locked door");
        }else{
            this.usage().lock(Item.UNLOCKED);
            this.name("Door")
                .examine("Whelp, that's a door alright!");
        }
        if(name != null){
            this.name(name)
                .synonym(name.toLowerCase());
        }
        this.synonym("door");
        this.key(key)
            .portal(portal);
    }
}
