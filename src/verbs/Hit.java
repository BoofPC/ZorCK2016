package verbs;

import core.*;

public class Hit extends Verb {

    public Hit() {
        super("hit", Verb.usage().noun(), "punch", "kick", "headbutt");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        final Player player = construct.getPlayer();
        final Area area = player.getCurrentArea();

        switch (noun.usage().stab()) {
            case STABABBLE:
                System.out.println("You hit the " + noun.name());
                if (noun.inside() != null) {
                    System.out.println("It dropped the " + noun.inside().name());
                }
                noun.drop(area);
                area.removeItem(noun);
                break;
            default:
                System.out.println("Now why would you do that?");
                break;
        }
    }
}
