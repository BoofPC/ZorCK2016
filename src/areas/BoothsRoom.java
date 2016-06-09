package areas;

import core.*;
import items.*;
import verbs.*;

public class BoothsRoom extends Area {

    public BoothsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().east(new Portal(false, Hallway02.class));
        this.title("Booth's Room")
                .description("This room feels as if much pain was experienced "
                        + "here. In the back, behind rows of tables, an old man "
                        + "by the name of Booth sits next to a stack of unused "
                        + "physics textbooks. There is an exit the the east.")
                .shortDescription("This room feels as if much pain was "
                        + "experienced here. There is an exit to the east")
                .smell("It smells like physics!")
                .taste("It tastes like science")
                .item(new Door(false, "Eastern Door", null, this.portals().east()))
                .item(new MrBooth()).item(new BoothsComputer());
    }

    @Override
    public void interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final String leftovers = command.getLeftovers();

        if (verb.getClass().equals(Type.class)) {
            if (leftovers.contains("compsci_is_fun!")) {
                this.getItem(BoothsComputer.class).usage().lock(Item.UNLOCKED);
                final Player player = context.getPlayer();
                player.addScore(10);
                System.out.println("You unlocked Booth's Computer and changed your grade to an A!");
                player.setDeath(Game.Status.WIN);
            } else {
                System.out.println("WRONG PASSWORD");
            }
        } else {
            super.interact(command, context);
        }

    }
}
