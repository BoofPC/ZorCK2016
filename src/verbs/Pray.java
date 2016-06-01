package verbs;
import core.*;
/**
 *
 * @author Samantha
 */
public class Pray extends Verb {
    
    public Pray() {
        super("pray",
                new String[] {"worship"},
                new boolean[] {true, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        
        player.setPrayer(true);
        System.out.println(player.getName() + " prayed!");
    }
}
