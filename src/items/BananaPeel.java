package items;

import core.*;

public class BananaPeel extends Item{
    public BananaPeel(){
        super();
        this.usage().take(Item.TAKABLE).move(Item.MOVABLE).wear(Item.WEARABLE);
        this.name("Banana Peel")
            .description("This is one of the parts of the time"
                + " machine!")
            .synonym("banana peel");
    }
}
