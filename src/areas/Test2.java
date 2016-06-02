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
            addItem(new Door(false,"Southern Door",new Key(),getPortal(2)));
            addItem(new Screwdriver());
            setState("First",true);
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
