package verbs;

import core.*;

public class Sit extends Verb {

    public Sit() {
        super("sit", Verb.usage().bare(), "lie down", "prone", "criss-cross applesauce");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        player.setSit(true);
        System.out.println(player.getName() + " sat!");
    }
}
