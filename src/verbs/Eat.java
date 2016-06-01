package verbs;
import core.*;
/**
 *
 * @author Samantha
 */
public class Eat extends Verb {
    
    public Eat() {
        super("eat",
                new String[] {"consume", "devour", "ingest"},
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        
        if(noun.getUsageKey(2) == 2){
            if(player.getCurrentArea().hasMatching(noun)) 
                player.getCurrentArea().removeItem(noun);
            else if(player.hasMatching(noun)) player.removeItem(noun);
            System.out.println(player.getName() + " ate the " + noun.getName());
            if(noun.getTaste() != null) System.out.println(noun.getTaste());
            else System.out.println("It tastes like every other " + 
                    noun.getName() + " you've ever eaten");
        }else{
            System.out.println("I don't see how you expect to do that!");
        }
    }
}
