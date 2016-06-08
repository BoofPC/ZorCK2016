package areas;

import core.*;

/**
 * This area is reached by walking off of the roof. If the player is here, that means that they fell
 * to their death.
 */

public class ConcreteGround extends Area {

    public ConcreteGround(final World containingWorld) {
        super(containingWorld);
        this.title("Air above the concrete ground").articleThe(true)
                .description(
                        "You see a very nice piece of concrete coming up to meet you. Hi, concrete!")
                .shortDescription("It's still the ground, and it's still concrete.");
    }

    @Override
    public void interact(final Command command, final Context context) {
        if (this.firstVisit()) {
            System.out.println("You wonder if it wants to be friends with you.");
            context.getPlayer().setDeath(Game.Status.SUICIDE);
            this.firstVisit(false);
        } else {
            super.interact(command, context);
        }
    }
}
