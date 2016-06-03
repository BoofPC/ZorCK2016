package items;

import core.*;

public class BananaPeel extends Item{
    public BananaPeel(){
        super();
        this.setUsageKey(Item.TAKE, 1);
        this.setUsageKey(Item.MOVE, 2);
        this.setUsageKey(Item.WEAR, 2);
        this.setName("Banana Peel");
        this.setDescription("This is one of the parts of the time"
                + " machine!");
        this.addSynonym("banana peel");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
