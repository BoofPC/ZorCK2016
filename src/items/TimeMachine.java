package items;

import core.*;
import java.util.ArrayList;
import java.util.List;

public class TimeMachine extends Item {
    public TimeMachine(){
        super();
        this.usage().active(Usage.Active.OFF).take(Usage.Take.TOO_HEAVY)
            .recieve(Usage.Recieve.RECIEVE);
        //We need to have different texts for different
        //if the user has different items needed for the
        //time machine, for now I will just keep it as it
        //needs all three items.
        this.name("Time Machine");
        this.synonym("time machine");
        this.description("This is a broken time machine. It"
                + " needs a flux capaciator, Mr.Fusion, and"
                + " a banana peel. It allows you to travel"
                + " back in time!");
        final List<String> keys = new ArrayList<String>();
        keys.add(new MrFusion().getName());
        keys.add(new BananaPeel().getName());
        keys.add(new FluxCapacitor().getName());
        this.keys(keys);
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}