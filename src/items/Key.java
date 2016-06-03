package items;

import core.*;

public class Key extends Item{

    public Key(final String name, final String description){
        super();
        this.usage.take(Usage.Take.TAKABLE);
        this.setName(name);
        if(!name.equals("key")) {
            this.addSynonym(name.toLowerCase());
        }
        this.addSynonym("key");
        this.setDescription(description);
    }

    public Key(){
        super();
        this.usage.lock(Usage.Lock.LOCKED);
        this.setName("Key");
        this.addSynonym("key");
        this.setDescription("A small, yellow key");
    }

    @Override
    public void interact(final Command command, final Context context){

    }

}
