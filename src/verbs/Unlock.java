package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author pedro
 */
public class Unlock extends Verb{
    
    public Unlock() {
        super("unlock", 
                new String[] {}, 
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
    
}
