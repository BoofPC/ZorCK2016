package areas;

import core.*;
import items.*;

public class Test08 extends Area{

       public Test08(final World containingWorld){
            super(containingWorld);
            this.getPortals().west(new Portal(false, "Test07"))
                .east(new Portal(false, "Test09"))
                .north(new Portal(false, "Test05"))
                .south(new Portal(false, "Test10"));
            this.setTitle("Test Area 8");
            this.setInitialDescription("This is the eighth test area, there is path "
                    + "leading east-west and path leading north. There is a cave"
                    + " to the south. There is a magic orb on the ground");
            this.setDescription("This is the eighth test area");
            this.setState("First",true);
            this.addItem(new MagicOrb());
       }

        @Override
        public void interact(final Command command, final Context context){
            if(command.getVerb().getTitle().equals("take") &&
                    command.getNoun().name().equals("Magic Orb")){
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
