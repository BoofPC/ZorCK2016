package items;
import core.*;
import java.util.ArrayList;

/**
 *
 * @author Alex Johnson
 */
public class TimeMachine extends Item {
    public TimeMachine(){
        super();
        setUsageKey(Item.TURN_ON, 2);
        setUsageKey(Item.TAKE, 2);
        setUsageKey(Item.RECEIVE, 2);
        //We need to have different texts for different
        //if the user has different items needed for the
        //time machine, for now I will just keep it as it
        //needs all three items.
        setName("Time Machine");
        addSynonym("time machine");
        setDescription("This is a broken time machine. It"
                + " needs a flux capaciator, Mr.Fusion, and"
                + " a banana peel. It allows you to travel"
                + " back in time!");
        ArrayList<Item> keys = new ArrayList<Item>();
        keys.add(new MrFusion());
        keys.add(new BananaPeel());
        keys.add(new FluxCapacitor());
        setKey(keys);
    }
    
    public void interact(Command command, Context context){
        
    }
}