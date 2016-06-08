package verbs;

import core.*;
import java.util.Arrays;

public class Point extends Verb {
    public Point() {
        super("point", Verb.usage().noun(), Arrays.asList("aim"));
    }

    @Override
    public void run(final Command command, final Context construct) {
        //will make it work with laser pointer
        System.out.println("It is rude to point!");
    }
}
