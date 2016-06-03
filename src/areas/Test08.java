package areas;

import core.*;
import items.*;

public class Test08 extends Area{

       public Test08(World containingWorld){
            super(containingWorld);
            getPortals().west(new Portal(false, "Test07"))
                .east(new Portal(false, "Test09"))
                .north(new Portal(false, "Test05"))
                .south(new Portal(false, "Test10"));
            setTitle("Test Area 8");
            setInitialDescription("This is the eighth test area, there is path "
                    + "leading east-west and path leading north. There is a cave"
                    + " to the south. There is a magic orb on the ground");
            setDescription("This is the eighth test area");
            setState("First",true);
            addItem(new MagicOrb());
       }
       
        public void interact(Command command, Context context){
            if(command.getVerb().getTitle().equals("take") && 
                    command.getNoun().getName().equals("Magic Orb")){
                context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 10);
                context.getPlayer().setHp(context.getPlayer().getHp() + 10);
                context.getPlayer().getCurrentArea().removeItem(command.getNoun());
                //
                System.out.println("The orb seeps into your skin");
                System.out.println("Your max HP just went up by 10!");
            }else{
                command.getVerb().run(command, context);
            }
            
            command.getVerb().run(command, context);
                
        }

}
