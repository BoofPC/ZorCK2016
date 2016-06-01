package verbs;
import core.*;
/**
 *
 * @author Samantha
 */
public class Climb extends Verb {
    
    public Climb() {
        super("climb",
                new String[] {"scale"},
                new boolean[] {true, true, false});
    }
    
    public void run(Command command, Context construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        
        if(noun != null){
            if(!noun.getName().equals("noItem")){
                if(noun.getUsageKey(13) == 2 && player.getCurrentArea().getPortal(8) 
                        != null){
                    if(!player.getCurrentArea().getPortal(8).isLocked())
                        construct.getPlayer().getCurrentArea().interact(new Command(new Move(), null, 8),construct);
                    else System.out.println("You can't climb that!");
                }else{
                    System.out.println("You can't climb that!");
                }
            }
            else construct.getPlayer().getCurrentArea().interact(new Command(new Move(), null, 8),construct);
        }else{
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
