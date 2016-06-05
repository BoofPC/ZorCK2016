package verbs;

import core.*;

public class Score extends Verb {

    public Score() {
        super("score", Verb.usage().bare(), "progress", "ranking", "rank");
    }

    @Override
    public void run(final Command command, final Context construct) {
        System.out.println("Your score is: " + construct.getPlayer().getScore());
    }
}
