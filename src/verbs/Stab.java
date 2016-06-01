package verbs;
import core.*;
import items.*;
/**
 *
 * @author Samantha
 */
public class Stab extends Verb {
    
    public Stab() {
        super("stab", 
                new String[] {"slice", "shank", "cut", "kill"},
                new boolean[] {false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        Area area = player.getCurrentArea();
        
        if(noun != null){
            if(!noun.getName().equals("noItem")){
                Item sword = new Sword();
                boolean test = false;
                for(int i = 0; i < player.listInventory().length; i++){
                    if(player.listInventory()[i].getName().equals(sword.getName())) 
                        test = true;
                }
                if(test){
                    if(noun.getUsageKey(11) == 2 || noun.getUsageKey(11) == 3){
                        noun.drop(area);
                        System.out.println("You stabbed the " + noun.getName());
                        if(noun.getInside() != null) System.out.println("It dropped the " 
                                + noun.getInside().getName());
                        noun.drop(area);
                        area.removeItem(noun);
                    }else{
                        System.out.println("Now why would you do that?");
                    }
                }else{
                    System.out.println("You need the " + sword.getName() 
                            + " to stab the " + noun.getName());
                }
            }
            else System.out.println("Ya need a noun, ya dingus");
        }else{
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
