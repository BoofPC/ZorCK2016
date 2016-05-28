package verbs;
import core.Verb;
/**
 *
 * @author Pedro
 */
public class Examine extends Verb{
    
    public Examine(){
        super("examine",
                new String[]{"look at","scan","study","observe"},
                new boolean[]{false,true,false});
    }
    
}
