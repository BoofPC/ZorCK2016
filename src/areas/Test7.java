/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;
import core.*;
import items.*;

/**
 *
 * @author pedro
 */
public class Test7 extends Area{

       public Test7(World containingWorld){
            super(containingWorld);
            setPortal(1, new Portal(false, "Test8"));
            setPortal(0, new Portal(false, "Test4"));
            setTitle("Test Area 7");
            setInitialDescription("This is the seventh test area, there is a "
                    + "path to the east and to the north. There is a Lantern "
                    + "on the ground");
            setDescription("This is the seventh test area");
            addItem(new Lantern());
            setState("First",true);  
       }
       
        public void interact(String command, Player player){
                
        }
    
        public void enter(Player player){
                
        }
    
        public void exit(Player player){
                
        }
       
}
