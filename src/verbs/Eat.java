package verbs;

import core.*;

public class Eat extends Verb {

    public Eat() {
        super("eat", Verb.usage().noun(), "consume", "devour", "ingest");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Command.NounOrigin nounOrigin = command.getNounOrigin();
        final Player player = construct.getPlayer();

        if (noun.usage().food() == Item.EDIBLE) {
            switch (nounOrigin) {
                case AREA:
                    player.getCurrentArea().removeItem(noun);
                    break;
                case PLAYER:
                    player.removeItem(noun);
                    break;
            }
            System.out.println(player.getName() + " ate the " + noun.name());
            if (noun.taste() != null) {
                System.out.println(noun.taste());
            } else {
                System.out.println(
                        "It tastes like every other " + noun.name() + " you've ever eaten");
            }
        } else {
            System.out.println("I don't see how you expect to do that!");
        }
    }
}
