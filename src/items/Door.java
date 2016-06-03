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
            this.name("Locked Door");
            this.description("You gotta find some way to unlock it!");
            this.synonym("locked door");
        }else{
            this.usage().lock(Usage.Lock.UNLOCKED);
            this.name("Door");
            this.description("Whelp, that's a door alright!");
        }
        if(name != null){
            this.name(name);
            this.synonym(name.toLowerCase());
        }
        this.synonym("door");
        final List<String> keys = new ArrayList<String>();
        keys.add(key);
        this.keys(keys);
        this.portal(portal);
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
