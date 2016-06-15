package areas;

import core.*;
import items.*;

public class SchuchartsRoom extends Area {

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
        final Verb verb = command.getVerb();
        if (verb.getTitle().equals("look") || verb.getTitle().equals("look around")) {
            System.out.println(this.shortDescription());
        } else {
            final Item noun = command.getNoun();
            if (verb.getTitle().equals("examine")
                    && (noun.equals("bin") || noun.equals("recycling bin"))) {
                System.out.println("Oh, hey, look! \nIt's your homework assignment. \n");
                context.getPlayer().addItem(new Assignment());
            } else if (verb.getTitle().equals("examine")
                    && (noun.equals("desk") || noun.equals("my desk")) || noun.equals("the desk")) {
                System.out.println("Don't be selfish, you're not\n"
                        + "the only one who sits here. It's been\ncleaned out.");
            } else {
                super.interact(command, context);
            }
        }
    }
}
