package verbs;
import core.*;
/**
 *
 * @author Samantha
 */
public class Climb extends Verb {
    
    public Climb() {
        super("climb",
                new String[] {"scale"},
                new boolean[] {true, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
