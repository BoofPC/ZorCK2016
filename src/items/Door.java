package items;

import core.*;

public class Door extends Item{

    public Door(final boolean locked,final String name,final String key,final Portal portal){
        super();
        this.usage().take(Item.BOLTED_DOWN).open(Item.CLOSED);
        if(locked){
            this.usage().lock(Item.LOCKED);
            this.name("Locked Door")
                .description("You gotta find some way to unlock it!")
                .synonym("locked door");
        }else{
            this.usage().lock(Item.UNLOCKED);
            this.name("Door")
                .description("Whelp, that's a door alright!");
        }
        if(name != null){
            this.name(name)
                .synonym(name.toLowerCase());
        }
        this.synonym("door");
        this.key(key)
            .portal(portal);
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
