package verbs;

import core.*;

public class Score extends Verb {

    public Score() {
        super("score",
                new String[]{"progress", "ranking", "rank"},
                Verb.usage().bare());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();

        System.out.println("Your score is: " + player.getScore());
    }
}
