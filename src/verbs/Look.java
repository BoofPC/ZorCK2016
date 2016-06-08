package verbs;

import core.*;

public class Look extends Verb {

    public Look() {
        super("look", Verb.usage().bare().direction(), "l");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        System.out.println(player.currentDescription());
    }
}
