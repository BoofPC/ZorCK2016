package verbs;

import core.*;

public class Drink extends Verb {

    public Drink() {
        super("drink", Verb.usage().noun(), "sip", "quaff");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Item.Usage usage = noun.usage();

        switch (usage.drink()) {
            case DRINKABLE:
                usage.drink(Item.EMPTY);
                System.out.println("You drank the " + noun.name());
                break;
            case CLOSED_DRINK:
                System.out.println("You need to open it first!");
                break;
            case EMPTY:
                System.out.println("You already drank that!");
                break;
            case UNDRINKABLE:
                System.out.println("You can't drink that!");
                break;
        }
    }
}
