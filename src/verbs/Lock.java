package verbs;
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
    
}
