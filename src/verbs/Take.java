package verbs;
import core.Verb;
/**
 *
 * @author keith5387h
 */
public class Take extends Verb{
    public Take(){
        super("take", new String[]{"get","obtain","pick up","pickup"}, new boolean[]{false, true, false});
    }
}
