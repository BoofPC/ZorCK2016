package items;

import core.*;

public class BananaPeel extends Item{
    public BananaPeel(){
        super();
        this.usage().take(Usage.Take.TAKABLE).move(Usage.Move.MOVABLE).wear(Usage.Wear.WEARABLE);
        this.name("Banana Peel");
        this.description("This is one of the parts of the time"
                + " machine!");
        this.synonym("banana peel");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
