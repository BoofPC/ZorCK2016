package areas;

import java.util.List;

import core.*;
import items.*;
import verbs.*;

/**
 * This area is reached by walking off of the roof. If the player is here, that means that they fell
 * to their death.
 */

public class ConcreteGround extends Area {

    public ConcreteGround(final World containingWorld) {
        super(containingWorld);
        this.title("air above some concrete ground").articleThe(true)
                .description(
                        "You see a very nice piece of concrete coming up to meet you. Hi, concrete!")
                .shortDescription("It's still the ground, and it's still concrete.");
    }

    @Override
    public void interact(final Command command, final Context context) {
        final Player player = context.getPlayer();
        if (this.firstVisit()) {
            final List<Item> inventory = player.getInventory();
            inventory.stream().filter(i -> i.usage().take() == Item.TAKABLE).forEach(this.items()::add);
            inventory.removeIf(i -> i.usage().take() == Item.TAKABLE);
            final MrBooth booth = this.getItem(MrBooth.class);
            if (booth == null) {
                System.out.println("You wonder if it wants to be friends with you.");
                player.setDeath(Game.Status.SUICIDE);
            } else {
                booth.changeState(MrBooth.State.FALLEN);
                this.articleThe(false).title("an area with concrete ground").description("That's a lot of concrete.");
                System.out
                        .println("Well, you're not dead. You must have really wanted that grade.");
            }
            this.firstVisit(false);
        } else {
            final Verb verb = command.getVerb();
            if (verb.getClass().equals(Move.class)) {
                System.out.println("Run.\n\nAchivement unlocked: Pyrrhic victory.");
                player.setDeath(Game.Status.WIN);
            } else {
                super.interact(command, context);
            }
        }
    }
}
