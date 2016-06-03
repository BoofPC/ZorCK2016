package areas;

import core.*;
import items.*;


// This is a template for Area
// For a more thorough explanation, see TutorialArea
public class AreaTemplate extends Area { // Be sure to replace this

    public AreaTemplate(final World containingWorld) { // And this
        super(containingWorld);
        /* Set the ones you need
        this.getPortals()
            .north(new Portal(, ""))
            .east(new Portal(, ""))
            .south(new Portal(, ""))
            .west(new Portal(, ""));
        */
        this.setTitle("");
        this.setInitialDescription("");
        this.setDescription("");
        // Add any necessary doors
        // (Here, the door faces south)
        this.addItem(new Door(false, "DOORNAME", null, this.getPortals().south()));

        /* Add these if you want
        this.addItem(ITEM);
        this.setTaste(STRING);
        this.setSmell(STRING);
        this.setSound(STRING);
        this.setDark(BOOLEAN); // if the player needs the lantern to see
        */
    }

    @Override
    public void interact(final Command command, final Context context) {
        Item noun;
        noun = command.getNoun();
        // if you don't have any special interactions, just put this:
        if (command.getNoun() != null) {
            noun.interact(command, context);
        }
        if (!context.getSkipGeneral()) {
            command.getVerb().run(command, context);
        }
    }

}
