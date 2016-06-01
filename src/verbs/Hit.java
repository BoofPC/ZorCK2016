package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Hit extends Verb {
    
    public Hit() {
        super("hit", 
                new String[] {"punch", "kick", "headbutt"},
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
