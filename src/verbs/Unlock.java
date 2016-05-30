package verbs;
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
    
}
