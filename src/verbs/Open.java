package verbs;

import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Cody
 */
public class Open extends Verb {
    public Open(){
        super("open", 
                new String[]{"unseal"}, 
                new boolean[]{false,true,false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}