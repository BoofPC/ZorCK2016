package verbs;
import core.Verb;
/**
 *
 * @author Samantha
 */

//killing yourself is a feature in the actual Zork game
//if you are offended by this, feel free to delete this class
public class Suicide extends Verb {
    
    public Suicide() {
        super("suicide",
                new String[] {"kill self", "orange monkey eagle"},
                new boolean[] {true, false, false});
    }
}