package items;

import core.*;

public class Key extends Item{

    public Key(final String name, final String description){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.name(name);
        if(!name.equals("key")) {
            this.synonym(name.toLowerCase());
        }
        this.synonym("key")
            .description(description);
    }

    public Key(){
        super();
        this.usage().lock(Usage.Lock.LOCKED);
        this.name("Key")
            .synonym("key")
            .description("A small, yellow key");
    }

    @Override
    public void interact(final Command command, final Context context){

    }

}
