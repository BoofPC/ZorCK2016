package verbs;
import core.*;
/**
 *
 * @author keith5387h
 */
public class Take extends Verb{
    public Take(){
        super("take", 
                new String[]{"get","obtain","pick up","pickup","steal"},
                new boolean[]{false, true, false});
    }
    
    public void run(Command command, Context construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        
        if(noun != null){
            if(!noun.getName().equals("noItem")){
                if(player.getCurrentArea().hasMatching(noun)){
                    if(noun.getUsageKey(1) == 1){
                        player.getCurrentArea().removeItem(noun);
                        player.addItem(noun);
                        System.out.println(player.getName() + " took the " 
                                + noun.getName());
                    }else if(noun.getUsageKey(1) == 2){
                        System.out.println("The " + noun.getName() 
                                + " is too heavy for that");
                    }else if(noun.getUsageKey(1) == 3){
                        System.out.println("The " + noun.getName() + " is bolted down");
                    }else{
                        System.out.println("You can't take the " + noun.getName());
                    }
                }
                else System.out.println("Where do you expect to find one of those?");
            }
            else System.out.println("Ya need a noun, ya dingus");
        }else{
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
