package items;

import core.*;

public class Lantern extends Item{

    public Lantern(){
        super();
        this.setUsageKey(Item.TAKE,1);
        this.setUsageKey(Item.TURN_ON,2);
        this.setName("Lantern");
        this.addSynonym("lantern");
        this.addSynonym("light");
        this.addSynonym("flashlight");

    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
