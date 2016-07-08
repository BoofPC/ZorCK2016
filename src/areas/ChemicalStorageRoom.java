package areas;

import core.*;
import items.*;

public class ChemicalStorageRoom extends Area<NoState> {

    public ChemicalStorageRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, BirkenfeldsRoom.class));
        this.title("Chemical Storage Room")
                .description("")
                .shortDescription("You're in the Chemical Storage room. You feel light headed.")
                .articleThe(true)
                .item(new Door(false, "Southern Door", null, this.portals().south()))
                .item(new Chemical()).item(new Vape())
                .smell("This room smells weird. You feel light headed.");
    }

    @Override
    public void interact(final Command command, final Context context) {
        super.interact(command, context);
    }
}
