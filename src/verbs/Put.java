package verbs;

import core.*;

public class Put extends Verb {

    public Put() {
        super("put", Verb.usage().noun(), "place", "set");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();
        
        if(player.hasMatching(noun)){
            if(noun.usage().puttable() == Item.PUTTABLE){
                player.removeItem(noun);
                player.getCurrentArea().item(noun);
                System.out.println("You put " + noun.name() + " in " + player.getCurrentArea());
            }
            else{
                System.out.println("I'm sorry " + player.getName() + ", I can't allow you to do that");
            }
        }
        else{
            System.out.println("You don't have the " + noun.name());
        }
    }
}
