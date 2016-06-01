package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class TurnOn extends Verb{
    
    public TurnOn() {
        super("turn on", 
                new String[] {"activate"}, 
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
    
}
