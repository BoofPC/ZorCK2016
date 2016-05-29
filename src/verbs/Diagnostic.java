package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Diagnostic extends Verb {
    
    public Diagnostic() {
        super("diagnostic",
                new String[] {"status"},
                new boolean[] {true, false, false});
    }
}
