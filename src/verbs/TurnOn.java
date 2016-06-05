package verbs;

import core.*;

public class TurnOn extends Verb {

    public TurnOn() {
        super("turn on", Verb.usage().noun(), "activate");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        switch (usage.active()) {
            case OFF:
                final Player player = construct.getPlayer();
                usage.active(Item.ON);
                System.out.println("You turned on the " + noun.name());
                final Area currentArea = player.getCurrentArea();
                if (currentArea.firstVisit()) {
                    currentArea.enter(player);
                }
                break;
            case ON:
                System.out.println(noun.name() + " is already on.");
                break;
            case STATIC:
                System.out.println("I don't see how you expect to do that.");
                break;
        }
    }

}
