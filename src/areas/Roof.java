package areas;

import core.*;
import items.*;

/**
 * This area contains toolbox. If you walk anywhere but west, you fall off of
 * the roof and die.
 */
public class Roof extends Area {

    public Roof(final World containingWorld) {
        super(containingWorld);

        this.portals()
                .south(new Portal(Portal.State.UNLOCKED, ConcreteGround.class))
                .west(new Portal(Portal.State.UNLOCKED, WomensRestroom.class));

        this.title("Roof").articleThe(true)
            .description("The roof is largely empty. Only a small red "
                + "toolbox lies on the ground. To the south is the edge of "
                + "the roof. To the west is a window leading to the Women's "
                + "Restroom.")

            .shortDescription("This is the roof.")

            .sound("You can hear the toolbox.")
            .smell("It smells like a red toolbox.")

            .item(new Toolbox());
    }

    @Override
    public void interact(final Command command, final Context context) {
        final World.Direction direction = command.getDirection();
        final Item noun = command.getNoun();
        final String verb = command.getVerb().getTitle();

        if (direction == World.Direction.SOUTH){
            System.out.println("Whoops. You walked off of the roof.");
            super.interact(command, context);
        } else if (verb.equals("take") && noun.name().equals("Toolbox")
            && this.items().contains(noun)) {
            this.sound("Sounds like there's no toolbox here.")
                    .smell("It smells"
                + " like there's no toolbox here.");
            command.getVerb().run(command, context);
        } else {
            super.interact(command, context);
        }
    }
}
