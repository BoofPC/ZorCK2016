package verbs;
import core.Verb;

/**
 *
 * @author Samantha
 */
public class Score extends Verb {

    public Score() {
        super("score",
                new String[] {"progress", "ranking", "rank"},
                new boolean[] {true, false, false});
    }
}
