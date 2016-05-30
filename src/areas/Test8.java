/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;
import core.Area;
import core.Player;
import core.Portal;
import core.World;
import items.Door;

/**
 *
 * @author pedro
 */
public class Test8 extends Area{

       public Test8(World containingWorld){
            super(containingWorld);
            setPortal(3, new Portal(false, "Test7"));
            setPortal(1, new Portal(false, "Test9"));
            setPortal(0, new Portal(false, "Test5"));
            setPortal(2, new Portal(false, "Test10"));
            setTitle("Test Area 8");
            setInitialDescription("This is the eighth test area, there is path "
                    + "leading east-west and path leading north. There is a cave"
                    + " to the south");
            setDescription("This is the eighth test area");
            setState("First",true);
       }
       
        public void interact(String command, Player player){
                
        }
    
        public void enter(Player player){
                
        }
    
        public void exit(Player player){
                
        }
       
}
