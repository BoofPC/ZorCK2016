package areas;

import core.*;
import items.*;

/**
 * Tutorial area based on {@link Test01}.
 */
public class TutorialArea extends Area {

    public TutorialArea(final World containingWorld) {
        // Always have this
        super(containingWorld);
        // Portals leading east to Test2 and south to Test4 (the way to Test4 is blocked)
        this.getPortals().east(new Portal(Portal.State.UNLOCKED, "Test02"))
                .south(new Portal(Portal.State.LOCKED, "Test04"));
        // This is the title of the area; it appears every move for which the player is in the area
        this.setTitle("Test Area 1");
        // This is the description of the area which appears when the player initially enters
        this.setInitialDescription("This is the first test area, there is path to "
                + "the east and a locked door to the south. There is dark "
                + "and white chocolate on the ground");
        // This is the description of the area which appears when the player inputs LOOK
        this.setDescription("This is the first test area");
        // The way to the south is blocked by a door, named "Southern Door", which uses the Key() item
        // named "Key" as a key and is connected to the southern portal. Set "Key" to the name of the
        // corresponding key, or to null
        this.addItem(new Door(true, "Southern Door", "Key", this.getPortals().south()));
        // This room contains both dark and white chocolate
        this.addItem(new DarkChocolate());
        this.addItem(new WhiteChocolate());
    }

    // If you don't have any special interactions, just put this.
    // To see how special interactions work, see Test8.
    @Override
    public void interact(final Command command, final Context context) {
        Item noun;
        noun = command.getNoun();
        // If you don't have any special interactions, just put this:
        if (command.getNoun() != null) {
            noun.interact(command, context);
        }
        if (!context.getSkipGeneral()) {
            command.getVerb().run(command, context);
        }
    }

}
