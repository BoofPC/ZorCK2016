package verbs;

import core.*;

public class TurnOff extends Verb {

    public TurnOff() {
        super("turn off", Verb.usage().noun(), "deactivate");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        switch (usage.active()) {
            case ON:
                usage.active(Item.OFF);
                System.out.println("You turned off the " + noun.name());
                break;
            case OFF:
                System.out.println(noun.name() + " is already off");
                break;
            case STATIC:
                System.out.println("I don't see how you expect to do that.");
                break;
        }
    }
}
