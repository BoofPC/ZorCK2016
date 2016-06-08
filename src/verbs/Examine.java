package verbs;

import core.*;

public class Examine extends Verb {

    public Examine() {
        super("examine", Verb.usage().noun(), "x", "look at", "scan", "study", "observe");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();

        final String examine = noun.examine();
        if (examine != null) {
            System.out.println(examine);
        } else {
            System.out.println("It looks like every other " + noun.name() + " you've ever seen");
        }

    }

}
