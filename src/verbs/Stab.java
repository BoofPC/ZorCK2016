package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Stab extends Verb {
    
    public Stab() {
        super("stab", 
                new String[] {"slice", "shank", "cut", "kill"},
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
