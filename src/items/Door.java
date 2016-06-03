package items;

import core.*;
import java.util.ArrayList;
import java.util.List;

public class Door extends Item{

    public Door(final boolean locked,final String name,final String key,final Portal portal){
        super();
        this.usage().take(Usage.Take.BOLTED_DOWN).open(Usage.Open.CLOSED);
        if(locked){
            this.usage().lock(Usage.Lock.LOCKED);
            this.name("Locked Door")
                .description("You gotta find some way to unlock it!")
                .synonym("locked door");
        }else{
            this.usage().lock(Usage.Lock.UNLOCKED);
            this.name("Door")
                .description("Whelp, that's a door alright!");
        }
        if(name != null){
            this.name(name)
                .synonym(name.toLowerCase());
        }
        this.synonym("door");
        final List<String> keys = new ArrayList<String>();
        keys.add(key);
        this.keys(keys)
            .portal(portal);
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
