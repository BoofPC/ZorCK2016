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
       
    @Override
    public void interact(Command command, Context context){
        Item noun;
        noun = command.getNoun();
        //if you don't have any special interactions, just put this:
        if(command.getNoun() !=  null)
            noun.interact(command,context);
        if(!context.getSkipGeneral())
            command.getVerb().run(command, context);
    }

}
