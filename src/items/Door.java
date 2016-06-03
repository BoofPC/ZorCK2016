package items;

import core.*;
import java.util.ArrayList;
import java.util.List;

public class Door extends Item{

    public Door(final boolean locked,final String name,final String key,final Portal portal){
        super();
        this.usage.take(Usage.Take.BOLTED_DOWN).open(Usage.Open.CLOSED);
        if(locked){
            this.usage.lock(Usage.Lock.LOCKED);
            this.setName("Locked Door");
            this.setDescription("You gotta find some way to unlock it!");
            this.addSynonym("locked door");
        }else{
            this.usage.lock(Usage.Lock.UNLOCKED);
            this.setName("Door");
            this.setDescription("Whelp, that's a door alright!");
        }
        if(name != null){
            this.setName(name);
            this.addSynonym(name.toLowerCase());
        }
        this.addSynonym("door");
        final List<String> keys = new ArrayList<String>();
        keys.add(key);
        this.setKeys(keys);
        this.setPortal(portal);
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
