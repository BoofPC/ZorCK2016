package items;

import core.*;

public class Chemical extends Item {

    public Chemical() {
        super();
        this.usage()
                .take(Item.TAKABLE);
        this.name("Chemical").look("It is green and nasty looking. It bubbles.")
                .synonym("chemical", "chemicals")
                .smell("It smells absolutely horrid. Like, worse than the Super Mario Bros. movie horrid.")
                .taste("It tastes exactly like Sprite.").read("Do Not Ingest!");
    }

    @Override
    public boolean interact(final Command command, final Context context) {
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();
        final Player player = context.getPlayer();

        if (verb.equals("drink")) {
            switch (noun) {
                case "Chemical":
                    System.out.println("I warned you.");
                    player.setDeath(Game.Status.SUICIDE);
                    break;
            }
            return true;
        } else if (verb.equals("drop")) {
            switch (noun) {
                case "Chemical":
                    System.out.println(
                            "The green slimy substance kills you upon its descent to the ground.");
                    player.setDeath(Game.Status.DIE);
                    return true;
            }
        }
        return false;
    }
}
