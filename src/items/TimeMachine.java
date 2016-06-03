package items;

import core.*;

public class TimeMachine extends Item {
    public TimeMachine(){
        super();
        this.usage().active(Usage.Active.OFF).take(Usage.Take.TOO_HEAVY)
            .recieve(Usage.Recieve.RECIEVE);
        //We need to have different texts for different
        //if the user has different items needed for the
        //time machine, for now I will just keep it as it
        //needs all three items.
        this.name("Time Machine")
            .synonym("time machine")
            .description("This is a broken time machine. It"
                + " needs a flux capaciator, Mr.Fusion, and"
                + " a banana peel. It allows you to travel"
                + " back in time!");
        this.key(new MrFusion().name()).key(new BananaPeel().name()).key(new FluxCapacitor().name());
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}