package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Eat extends Verb {
    
    public Eat() {
        super("eat",
                new String[] {"consume", "devour", "ingest"},
                new boolean[] {false, true, false});
    }
}
