package items;

import core.*;

public class AnonymousNote extends Item {

    public AnonymousNote() {
        super();
        this.setUsageKey(Item.TAKE, 2);
        this.setUsageKey(Item.READ, 2);
        this.setName("Anonymous Note");
        this.setDescription("It's a note from an unknown author...");
        this.addSynonym("anonymous note");
        this.addSynonym("note");
        this.setText("You won't believe this but, I need you to go back"
                + " in time and force Mr.Booth to grade the assignments"
                + " so that the world doesn't end. If you don't do this"
                + " tomorrow the world will look very different from what"
                + " you see now... I'm running out of paper so I'll have to"
                + " be quick. Find the Time machine and...");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
