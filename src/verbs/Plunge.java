package verbs;

import core.*;
import items.Plunger;

public class Plunge extends Verb {
    
    public Plunge() {
        super("plunge", Verb.usage().noun(), "use plunger");
    }

    @Override
    public void run(Command command, Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();
        final Item.Usage usage = noun.usage();
        
        if (player.hasItem(Plunger.class)) {
            switch (usage.plungable()) {
                case PLUNGABLE:
                    noun.interact(command, construct);
                    break;
                default:
                    System.out.println("I don't see how you expect to do that!");
                    break;
            }
        } else {
            System.out.println("You need a Plunger to do that!");
        }
    }
    
}