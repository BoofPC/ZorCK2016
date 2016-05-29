package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Restart extends Verb {
    
    public Restart() {
        super("restart",
                new String[] {"reset", "start over","restart game"},
                new boolean[] {true, false, false});
    }
}
