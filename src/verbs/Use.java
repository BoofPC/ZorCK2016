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
        final Player player = construct.getPlayer();
        
        //confusing
        if (usage.use() == Item.USABLE) {
            if (player.getCurrentArea().hasMatching(noun) 
                    || player.hasMatching(noun)) {
                noun.interact(command, construct);
            }
            System.out.println("You used the " + noun.name());
        } else {
            System.out.println("I don't see how you expect to do that!");
        }
        
    }
    
}
