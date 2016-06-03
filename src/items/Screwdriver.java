package items;

import core.*;

public class Screwdriver extends Item{

    public Screwdriver(){
        super();
        this.usage.take(Usage.Take.TAKABLE);
        this.setName("Flathead Screwdriver");
        this.addSynonym("flathead screwdriver");
        this.addSynonym("screwdriver");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
