package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Read extends Verb {
    public Read() {
        super("read",
                //I dunno. What else would someone say?
                new String[] {"peruse", "study"},
                new boolean[] {false, true, false});
    }
}
