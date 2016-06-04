package verbs;

import java.util.Arrays;

import core.*;
import items.*;

public class Stab extends Verb {

    public Stab() {
        super("stab", Arrays.asList("slice", "shank", "cut", "kill"), Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();
        final Area area = player.getCurrentArea();

        final String swordName = new Sword().name();
        if (player.hasItem(swordName)) {
            if (noun.usage().stab() == Item.STABABBLE) {
                noun.drop(area);
                System.out.println("You stabbed the " + noun.name());
                if (noun.inside() != null) {
                    System.out.println("It dropped the " + noun.inside().name());
                }
                noun.drop(area);
                area.removeItem(noun);
            } else {
                System.out.println("Now why would you do that?");
            }
        } else {
            System.out.println("You need the " + swordName + " to stab the " + noun.name());
        }
    }
}
