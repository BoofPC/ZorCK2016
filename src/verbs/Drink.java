package verbs;

import java.util.Arrays;

import core.*;

public class Drink extends Verb {

    public Drink() {
        super("drink",
                Arrays.asList("sip", "quaff"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                switch (noun.usage().drink()) {
                    case DRINKABLE:
                        noun.usage().drink(Item.Usage.Drink.EMPTY);
                        System.out.println("You drank the " + noun.getName());
                        break;
                    case CLOSED:
                        System.out.println("You need to open it first!");
                        break;
                    case EMPTY:
                        System.out.println("You already drank that!");
                        break;
                    default:
                        System.out.println("You can't drink that!");
                        break;
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
