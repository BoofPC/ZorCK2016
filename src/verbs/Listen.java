package verbs;

import core.*;

public class Listen extends Verb {

    public Listen() {
        super("listen", Verb.usage().bare().noun(), "hear", "pay attention", "listen to");
    }

    @Override
    public void run(final Command command, final Context construct) {
        if (command.isBare()) {
            final String sound = construct.getPlayer().getCurrentArea().getSound();
            if (sound != null) {
                System.out.println(sound);
            } else {
                System.out.println("It doesn't sound like anything");
            }
        } else {
            final Item noun = command.getNoun();
            final String sound = noun.sound();
            if (sound != null) {
                System.out.println(sound);
            } else {
                System.out.println(
                        "It sounds like every other " + noun.name() + " you've ever heard");
            }
        }
    }
}
