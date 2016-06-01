package core;

/**
 *
 * @author pedro
 */
public class Command {
    
    public final Verb verb;
    public final Item noun;
    public final int direction;
    
    public Command(Verb verb, Item noun, int direction){
        this.verb = verb;
        this.noun = noun;
        this.direction = direction;
    }
         
}
