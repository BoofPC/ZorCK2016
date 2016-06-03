package items;

import core.*;

public class Screwdriver extends Item{

    public Screwdriver(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.name("Flathead Screwdriver");
        this.synonym("flathead screwdriver");
        this.synonym("screwdriver");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
