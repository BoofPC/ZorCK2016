package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author pedro
 */
public class Lock extends Verb{
    
    public Lock() {
        super("lock", 
                new String[] {}, 
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
    
}
