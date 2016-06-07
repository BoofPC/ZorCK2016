package verbs;

import core.*;

public class Taste extends Verb {

    public Taste() {
        super("taste", Verb.usage().bare().noun(), "lick", "sample");
    }

    @Override
    public void run(final Command command, final Context construct) {
        if (command.isBare()) {
            final String taste = construct.getPlayer().getCurrentArea().taste();
            if (taste != null) {
                System.out.println(taste);
            } else {
                System.out.println("It doesn't taste like anything");
            }
        } else {
            final Item noun = command.getNoun();
            final String taste = noun.taste();
            if (taste != null) {
                System.out.println(taste);
            } else {
                System.out.println(
                        "It tastes like every other " + noun.name() + " you've ever tasted.");
            }
        }
    }
}
