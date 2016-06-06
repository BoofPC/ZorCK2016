package verbs;

import core.*;

/**
 *
 * @author Samantha
 */
public class Use extends Verb {
    
    public Use() {
        super("use", Verb.usage().noun());
    }
    
    @Override
    public void run(Command command, Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();
        
        noun.interact(command, construct);
    }
    
}
