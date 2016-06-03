package items;

import core.*;

public class Screwdriver extends Item{

    public Screwdriver(){
        super();
        this.setUsageKey(Item.TAKE,1);
        this.setName("Flathead Screwdriver");
        this.addSynonym("flathead screwdriver");
        this.addSynonym("screwdriver");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
