package verbs;
import core.Verb;
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
}
