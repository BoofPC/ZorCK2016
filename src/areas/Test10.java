/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;
import core.*;

/**
 *
 * @author pedro
 */
public class Test10 extends Area{

       public Test10(World containingWorld){
            super(containingWorld);
            setPortal(0, new Portal(false, "Test8"));
            setTitle("Test Area 10");
            setInitialDescription("This is the tenth test area. You are in a "
                    + "cave! There is exit to the north");
            setDescription("This is the tenth test area");
            setState("First",true);
            setDark(true);
       }
       
        public void interact(Command command, Context construct){
                command.getVerb().run(command, construct);
        }

}
