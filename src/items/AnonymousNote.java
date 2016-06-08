package items;

import core.*;

public class AnonymousNote extends Item {

    public AnonymousNote() {
        super();
        this.usage().take(Item.TOO_HEAVY).read(Item.READABLE);
        this.name("Anonymous Note")
            .look("A scribbled note lies peacefully.")
            .examine("It's a note from an unknown author...")
            .synonym("anonymous note", "note")
            .read("You won't believe this but, I need you to go back"
                + " in time and force Mr.Booth to grade the assignments"
                + " so that the world doesn't end. If you don't do this"
                + " tomorrow the world will look very different from what"
                + " you see now... I'm running out of paper so I'll have to"
                + " be quick. Find the Time machine and...");
    }
}
