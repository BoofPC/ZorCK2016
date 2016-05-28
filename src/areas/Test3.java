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

/**
 *
 * @author pedro
 */
public class Test3 extends Area{

       public Test3(World containingWorld){
            super(containingWorld);
            setPortal(3, new Portal(false, "Test2"));
            setPortal(2, new Portal(false, "Test6"));
            setTitle("Test Area 3");
            setInitialDescription("This is the third test area, there is path "
                    + "leading west and a path leading south");
            setDescription("This is the third test area");
            setState("First",true);   
       }
       
        public void interact(String command, Player player){
                
        }
    
        public void enter(Player player){
                
        }
    
        public void exit(Player player){
                
        }
       
}
