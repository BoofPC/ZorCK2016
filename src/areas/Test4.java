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
public class Test4 extends Area{

       public Test4(World containingWorld){
            super(containingWorld);
            setPortal(0, new Portal(true, "Test1"));
            setPortal(1, new Portal(false, "Test5"));
            setPortal(2, new Portal(false, "Test7"));
            setTitle("Test Area 4");
            setInitialDescription("This is the fourth test area, there are paths"
                    + " to the east and south and a locked door to the north.");
            setDescription("This is the fourth test area"); 
            addItem(new Door(true,"Northern Door",new Key(),getPortal(0)));
            setState("First",true);
       }
       
        public void interact(String command, Player player){
                
        }
    
        public void enter(Player player){
                
        }
    
        public void exit(Player player){
                
        }
       
}
