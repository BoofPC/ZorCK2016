package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Eat extends Verb {
    
    public Eat() {
        super("eat",
                new String[] {"consume", "devour", "ingest"},
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
