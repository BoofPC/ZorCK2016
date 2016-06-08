package verbs;

import core.*;
import items.*;

public class Stab extends Verb {

    public Stab() {
        super("stab", Verb.usage().noun(), "slice", "shank", "cut", "kill");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();
        final Area area = player.getCurrentArea();

        if (player.hasItem(Sword.class)) {
            switch (noun.usage().stab()) {
                case STABABBLE:
                    System.out.println("You stabbed the " + noun.name());
                    if (noun.inside() != null) {
                        System.out.println("It dropped the " + noun.inside().name());
                    }
                    noun.drop(area);
                    area.removeItem(noun);
                    break;
                default:
                    System.out.println("Now why would you do that?");
                    break;
            }
        } else {
            System.out.println("You need the " + new Sword().name() + " to stab the " + noun.name());
        }
    }
}
