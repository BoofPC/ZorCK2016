package areas;

import core.*;
import items.*;

public class SchuchartsRoom extends Area<NoState> {

    public SchuchartsRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().south(new Portal(false, Hallway16.class));
        this.title("Schuchart's Room").description("----------")
                .shortDescription("It's still Schuchart's room,\nthe way it's always been.")
                .dark(false).smell("Smells like the 14th Amendment.")
                .taste("Tastes like the battle of Saratoga.")
                .sound("Nothing like the sounds of history.")
                .item(new Door(false, "Southern Door", null, this.portals().south()));
    }

    @Override
    public void interact(final Command command, final Context context) {
        super.interact(command, context);
    }
}
