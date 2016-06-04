package verbs;

import java.util.Arrays;

import core.*;

public class Smell extends Verb {

    public Smell() {
        super("smell", Arrays.asList("sniff"), Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        if (command.isBare()) {
            final String smell = construct.getPlayer().getCurrentArea().getSmell();
            if (smell != null) {
                System.out.println(smell);
            } else {
                System.out.println("It doesn't smell like anything");
            }
        } else {
            final Item noun = command.getNoun();
            final String smell = noun.smell();
            if (smell != null) {
                System.out.println(smell);
            } else {
                System.out.println(
                        "It smells like every other " + noun.name() + " you've ever smelled.");
            }
        }
    }
}
