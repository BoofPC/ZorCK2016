package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Shout extends Verb {
    
    public Shout() {
        super("shout",
                new String[] {"scream", "yell"},
                new boolean[] {true, true, false});
    }
}
