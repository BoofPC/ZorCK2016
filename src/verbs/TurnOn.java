package verbs;

import java.util.Arrays;

import core.*;

public class TurnOn extends Verb {

    public TurnOn() {
        super("turn on",
                Arrays.asList("activate"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                if (noun.usage().active() == Item.OFF) {
                    noun.usage().active(Item.ON);
                    System.out.println("You turned on the " + noun.name());
                    if (player.getCurrentArea().getFirstVisit()) {
                        player.getCurrentArea().enter(player);
                    }
                } else if (noun.usage().active() == Item.ON) {
                    System.out.println(noun.name() + " is already on");
                } else {
                    System.out.println("I don't see how you expect to do that");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }

}
