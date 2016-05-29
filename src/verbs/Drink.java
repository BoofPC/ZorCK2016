package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Drink extends Verb {
    
    public Drink() {
        super("drink",
                new String[] {"sip", "quaff"},
                new boolean[] {false, true, false});
    }
}
