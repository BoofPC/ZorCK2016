package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Pray extends Verb {
    
    public Pray() {
        super("pray",
                new String[] {"worship"},
                new boolean[] {true, true, false});
    }
}
