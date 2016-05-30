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
public class Test5 extends Area{

       public Test5(World containingWorld){
            super(containingWorld);
            setPortal(0, new Portal(false, "Test2"));
            setPortal(3, new Portal(false, "Test4"));
            setPortal(1, new Portal(false, "Test6"));
            setPortal(2, new Portal(false, "Test8"));
            setTitle("Test Area 5");
            setInitialDescription("This is the fifth test area, there is path "
                    + "leading east-west, a door to the north, and a path to "
                    + "the south.");
            setDescription("This is the fifth test area");   
            addItem(new Door(false,"Northern Door",new Key(),getPortal(0)));
            setState("First",true);
       }
       
        public void interact(String command, Player player){
                
        }
    
        public void enter(Player player){
                
        }
    
        public void exit(Player player){
                
        }
       
}
