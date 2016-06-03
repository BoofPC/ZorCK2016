package items;

import core.*;

public class BananaPeel extends Item{
    public BananaPeel(){
        super();
        this.usage.take(Usage.Take.TAKABLE).move(Usage.Move.MOVABLE).wear(Usage.Wear.WEARABLE);
        this.setName("Banana Peel");
        this.setDescription("This is one of the parts of the time"
                + " machine!");
        this.addSynonym("banana peel");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
