package verbs;

import java.util.Arrays;

import core.*;

public class Hit extends Verb {

    public Hit() {
        super("hit",
                Arrays.asList("punch", "kick", "headbutt"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();
        final Area area = player.getCurrentArea();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.usage.stab() == Item.Usage.Stab.STABABBLE) {
                    noun.drop(area);
                    System.out.println("You hit the " + noun.getName());
                    if (noun.getInside() != null) {
                        System.out.println("It dropped the "
                                + noun.getInside().getName());
                    }
                    noun.drop(area);
                    area.removeItem(noun);
                } else {
                    System.out.println("Now why would you do that?");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
