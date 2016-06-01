package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Pray extends Verb {
    
    public Pray() {
        super("pray",
                new String[] {"worship"},
                new boolean[] {true, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
