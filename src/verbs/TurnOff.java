package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class TurnOff extends Verb {
    
    public TurnOff() {
        super("turn off",
                new String[] {"deactivate"},
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
