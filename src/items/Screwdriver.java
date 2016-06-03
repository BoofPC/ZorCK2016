package items;

import core.*;

public class Screwdriver extends Item{

    public Screwdriver(){
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Flathead Screwdriver")
            .synonym("flathead screwdriver")
            .synonym("screwdriver");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
