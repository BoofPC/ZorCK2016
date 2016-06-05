package areas;

import core.*;
import items.*;

public class HendrichsonsRoom extends Area {

    public HendrichsonsRoom(final World containingWorld) {
        super(containingWorld);
        this.portals()
            .west(new Portal(Portal.State.UNLOCKED, "Hallway01"));
        this.initialDescription("You are in Hendrichson's room. It contains lab benches "
                + "with chemicals and physics projects. You see a balloon on the floor "
                + "that looks as if it has been recently used.")
            .description("You are in Hendrichson's room.")
            .smell("It smells like sodium chloride.")
            .sound("You don't hear anything. It is eerie...")
            .item(new Door(false, "Western Door", null, this.portals().west()));
    }

    @Override
    public void interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final Item noun = command.getNoun();
        if (verb.getTitle().equals("look")) {
            System.out.println(this.description());
        } else {
            if (verb.getTitle().equals("take") && noun.equals("balloon")) {
                System.out.println("The saliva from the previous user of the balloon "
                        + "acts as adhesive to keep the balloon on the ground.");
            } else if (verb.getTitle().equals("drink") && (noun.equals("chemical")
                    || noun.equals("chemicals"))) {
                final Player player = context.getPlayer();
                System.out.println("Bad choice. You have died.");
                player.setDeath(Game.Status.SUICIDE);
            } else {
                super.interact(command, context);
            }
        }
    }
}
