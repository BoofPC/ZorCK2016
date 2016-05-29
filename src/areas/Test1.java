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
public class Test1 extends Area{

       public Test1(World containingWorld){
            super(containingWorld);
            setPortal(1, new Portal(false, "Test2"));
            setPortal(2, new Portal(true, "Test4"));
            setTitle("Test Area 1");
            setInitialDescription("This is the first test area, there is path to "
                    + "the east and a locked door to the south");
            setDescription("This is the first test area");   
            addItem(new Door(true,"Southern Door"));
            setState("First",true);
       }
       
        public void interact(String command, Player player){
                
        }
    
        public void enter(Player player){
                
        }
    
        public void exit(Player player){
                
        }
       
}
