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
public class Test6 extends Area{

       public Test6(World containingWorld){
            super(containingWorld);
            setPortal(0, new Portal(false, "Test3"));
            setPortal(3, new Portal(false, "Test5"));
            setPortal(2, new Portal(false, "Test9"));
            setTitle("Test Area 6");
            setInitialDescription("This is the sixth test area, there is path "
                    + "leading west and a path leading north-south. There is "
                    + "a key on the ground");
            setDescription("This is the sixth test area"); 
            addItem(new Key());
            setState("First",true);  
       }
       
        public void interact(Command command, Context construct){
                command.getVerb().run(command, construct);
        }

}
