package items;

import core.*;
import java.util.ArrayList;
import java.util.List;

public class Door extends Item{

    public Door(final boolean locked,final String name,final String key,final Portal portal){
        super();
        this.setUsageKey(Item.TAKE,3);
        this.setUsageKey(Item.OPEN,2);
        if(locked){
            this.setUsageKey(Item.LOCK,3);
            this.setName("Locked Door");
            this.setDescription("You gotta find some way to unlock it!");
            this.addSynonym("locked door");
        }else{
            this.setUsageKey(Item.LOCK,2);
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
