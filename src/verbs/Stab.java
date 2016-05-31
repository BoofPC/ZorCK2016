package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */
public class Stab extends Verb {
    
    public Stab() {
        super("stab", 
                new String[] {"slice", "shank", "cut", "kill"},
                new boolean[] {false, true, false});
    }
}
