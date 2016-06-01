package verbs;
import core.Command;
import core.PlayerConstruct;
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
    
    public void run(Command command, PlayerConstruct construct){
        
    }
    
}
