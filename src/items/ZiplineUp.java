package items;

import core.*;
import areas.*;
import verbs.*;

public class ZiplineUp extends Item {

    public ZiplineUp(final boolean locked) {
        super();
        this.usage().take(Item.BOLTED_DOWN).open(Item.CLOSED);
        this.usage().lock(Item.LOCKED);
        this.name("Steep Zipline")
            .examine("You gotta find some way to get up it!")
            .synonym("steep zipline", "zipline")
            .key(Motor.class)
            .portal(new Portal(true, Roof.class));
    }

    @Override
    public boolean interact(final Command command, final Context context) {
        final Player player = context.getPlayer();
        final Verb verb = command.getVerb();
        final Item noun = command.getNoun();

        if (verb.getClass().equals(Put.class) && noun.getClass().equals(Motor.class)) {
            System.out.println("The motor attaches to the zipline like that was"
                    + " the intended purpose. Kinda strange. You could probably go up now.");
            player.removeItem(player.getItem(Motor.class));
            this.usage().lock(Item.UNLOCKED);
            this.name("Zipline").examine("That zipline looks like fun!");
            this.synonyms().remove("steep zipline");
            return true;
        }
        return false;
    }
}
