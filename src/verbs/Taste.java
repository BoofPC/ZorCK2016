/*8
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
public class Taste extends Verb {
    
    public Taste(){
        super("taste",
                new String[]{"lick","sample"},
                new boolean[]{true, true, false});
    }
    
    public void run(Command command, Context construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        Area area = player.getCurrentArea();
        
        if(noun != null){
            if(!noun.getName().equals("noItem")){
                if(noun.getTaste() != null) System.out.println(noun.getTaste());
                else System.out.println("It tastes like every other " + 
                        noun.getName() + " you've ever tried");
            }
            else{
                if(area.getTaste() != null) System.out.println(area.getTaste());
                else System.out.println("It doesn't taste like anything");
            }
        }else{
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
