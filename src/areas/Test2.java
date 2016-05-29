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
public class Test2 extends Area{

       public Test2(World containingWorld){
            super(containingWorld);
            setPortal(3, new Portal(false, "Test1"));
            setPortal(1, new Portal(false, "Test3"));
            setPortal(2, new Portal(false, "Test5"));
            setTitle("Test Area 2");
            setInitialDescription("This is the second test area, there is path "
                    + "leading east-west and a door to the south. There is a "
                    + "screwdriver on the ground");
            setDescription("This is the second test area");
            addItem(new Door(false,"Southern Door"));
            addItem(new Screwdriver());
            setState("First",true);
       }
       
        public void interact(String command, Player player){
                
        }
    
        public void enter(Player player){
                
        }
    
        public void exit(Player player){
                
        }
       
}
