package verbs;

import core.*;

public class Score extends Verb {

    public Score() {
        super("score",
                new String[]{"progress", "ranking", "rank"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        command.getNoun();

        Player player = construct.getPlayer();
        construct.getWorld();

        System.out.println("Your score is: " + player.getScore());
    }
}
