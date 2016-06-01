package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author keith5387h
 */
public class Take extends Verb{
    public Take(){
        super("take", 
                new String[]{"get","obtain","pick up","pickup","steal"},
                new boolean[]{false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
