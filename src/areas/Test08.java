package areas;

import core.*;
import items.*;

public class Test08 extends Area {

    public Test08(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .west(new Portal(false, "Test07"))
            .east(new Portal(false, "Test09"))
            .north(new Portal(false, "Test05"))
            .south(new Portal(false, "Test10"));
        this.title("Test Area 8")
            .initialDescription("This is the eighth test area, there is path "
                + "leading east-west and path leading north. There is a cave"
                + " to the south. There is a magic orb on the ground")
            .description("This is the eighth test area")
            .state("First", true)
            .item(new MagicOrb());
    }

    @Override
    public void interact(final Command command, final Context context) {
        if (command.getVerb().getTitle().equals("take")
                && command.getNoun().name().equals("Magic Orb")) {
            final Player player = context.getPlayer();
            player.setMaxHp(player.getMaxHp() + 10);
            player.setHp(player.getHp() + 10);
            player.getCurrentArea().removeItem(command.getNoun());
            System.out.println("The orb seeps into your skin");
            System.out.println("Your max HP just went up by 10!");
        } else {
            command.getVerb().run(command, context);
        }

        command.getVerb().run(command, context);
    }

}
