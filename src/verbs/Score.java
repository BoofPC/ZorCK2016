package verbs;

import core.*;

/**
 *
 * @author Samantha
 */
public class Score extends Verb {

    public Score() {
        super("score",
                new String[]{"progress", "ranking", "rank"},
                new boolean[]{true, false, false});
    }

    public void run(Command command, Context construct) {
        int direction = command.getDirection();
        Item noun = command.getNoun();

        Player player = construct.getPlayer();
        World world = construct.getWorld();

        System.out.println("Your score is: " + player.getScore());
    }
}
