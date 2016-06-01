/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbs;
import core.*;
/**
 *
 * @author Alex Johnson
 */
public class Close extends Verb {
    
    public Close(){
        super("close", 
                new String[]{"shut"},
                new boolean[]{false, true, false});
        
    }
    
    public void run(Command command, Context construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        
        if(noun != null){
            if(!noun.getName().equals("noItem")){
                if(noun.getUsageKey(4) == 3){
                    noun.setUsageKey(4,2);
                    System.out.println("You closed the " + noun.getName());
                }else if(noun.getUsageKey(4) == 2){
                    System.out.println(noun.getName() + " is already closed");
                }else{
                    System.out.println("I don't see how you expect to do that");
                }
            }
            else System.out.println("Ya need a noun, ya dingus");
        }else{
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
