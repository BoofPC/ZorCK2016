package items;

import core.Item;

/**
 *
 * @author Alex Johnson
 */
public class AnonymousNote extends Item {

    public AnonymousNote() {
        super();
        setUsageKey(Item.TAKE, 2);
        setUsageKey(Item.READ, 2);
        setName("Anonymous Note");
        setDescription("It's a note from an unknown author...");
        addSynonym("anonymous note");
        addSynonym("note");
        setText("You won't believe this but, I need you to go back"
                + " in time and force Mr.Booth to grade the assignments"
                + " so that the world doesn't end. If you don't do this"
                + " tomorrow the world will look very different from what"
                + " you see now... I'm running out of paper so I'll have to"
                + " be quick. Find the Time machine and...");
    }
}
