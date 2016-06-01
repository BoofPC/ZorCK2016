package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author pedro
 */



//A note about Give:
//The inputs "Give item to Booth" and "Give item" are syntactically identical
//Because of the simplicity of our parser, you should only have one item
//which can receive in any room at any time, or else the player cannot choose
//whith item to give to



public class Give extends Verb {
    
    public Give() {
        super("give",
                new String[] {"gift", "pay"},
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
