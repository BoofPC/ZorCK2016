package areas;

import core.*;
import items.*;


// This is a template for Area
// For a more thorough explanation, see TutorialArea
public class AreaTemplate extends Area { // Be sure to replace this

    public AreaTemplate(final World containingWorld) { // And this
        super(containingWorld);
        /* Set the ones you need
        this.portals()
            .north(new Portal(, .class))
            .east(new Portal(, .class))
            .south(new Portal(, .class))
            .west(new Portal(, .class));
        */
        this.title("")
            .description("")
            .shortDescription("")
        // Add any necessary doors
        // (Here, the door faces south)
            .item(new Door(false, "DOORNAME", null, this.portals().south()));

        /* Add these if you want
        this.item(ITEM)
            .taste(STRING)
            .smell(STRING)
            .sound(STRING)
            .dark(BOOLEAN); // if the player needs the lantern to see
        */
    }

    // If you don't have any special interactions, leave this out.
    // If you do, this is a good base.
    @Override
    public void interact(final Command command, final Context context) {
        super.interact(command, context);
    }

}
