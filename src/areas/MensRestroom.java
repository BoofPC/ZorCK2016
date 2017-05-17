package areas;

import core.*;
import items.*;

public class MensRestroom extends Area<NoState> {

    public MensRestroom(final World containingWorld) {
        super(containingWorld);
        this.portals().south(new Portal(false, Hallway14.class));
        this.title("Men's Restroom")
                .description("There are toilets and sinks and there is paper\n"
                        + "piled against the waste basket.")
                .shortDescription("It's still the men's restroom.\n"
                        + "Always a pleasure to look at.\nThere's the ketchup.")
                .articleThe(true).smell("That is truly disgusting.")
                .taste("That sounds unsanitary at best.")
                .sound("Thankfully, there are no other sounds.")
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
