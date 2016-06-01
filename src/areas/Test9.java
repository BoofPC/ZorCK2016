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
public class Test9 extends Area{

       public Test9(World containingWorld){
            super(containingWorld);
            setPortal(3, new Portal(false, "Test8"));
            setPortal(0, new Portal(false, "Test6"));
            setTitle("Test Area 9");
            setInitialDescription("This is the ninth test area, there is path "
                    + "leading west and a path leading north. There is a "
                    + "Hamburger on the ground.");
            setDescription("This is the ninth test area");   
            setState("First",true);
            addItem(new Hamburger());
       }
       
        public void interact(Command command, Context construct){
                command.getVerb().run(command, construct);
        }

}
