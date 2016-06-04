package verbs;

import java.util.Arrays;

import core.*;

public class Hit extends Verb {

    public Hit() {
        super("hit", Arrays.asList("punch", "kick", "headbutt"), Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();
        final Area area = player.getCurrentArea();

        if (noun.usage().stab() == Item.STABABBLE) {
            noun.drop(area);
            System.out.println("You hit the " + noun.name());
            if (noun.inside() != null) {
                System.out.println("It dropped the " + noun.inside().name());
            }
            noun.drop(area);
            area.removeItem(noun);
        } else {
            System.out.println("Now why would you do that?");
        }
    }
}
