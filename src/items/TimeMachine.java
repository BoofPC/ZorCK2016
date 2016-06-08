package items;

import core.*;

public class TimeMachine extends Item {
    public TimeMachine(){
        super();
        this.usage().active(Item.OFF).take(Item.TOO_HEAVY)
            .recieve(Item.RECIEVE);
        //We need to have different texts for different
        //if the user has different items needed for the
        //time machine, for now I will just keep it as it
        //needs all three items.
        this.name("Time Machine")
            .synonym("time machine")
            .examine("This is a broken time machine. It"
                + " needs a flux capaciator, Mr.Fusion, and"
                + " a banana peel. It allows you to travel"
                + " back in time!");
        this.key(MrFusion.class).key(BananaPeel.class).key(FluxCapacitor.class);
    }
}