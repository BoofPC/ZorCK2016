package verbs;

import java.util.Arrays;

import core.*;

public class Score extends Verb {

    public Score() {
        super("score",
                Arrays.asList("progress", "ranking", "rank"),
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
