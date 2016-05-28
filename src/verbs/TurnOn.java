package verbs;
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
    
}
