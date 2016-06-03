package verbs;

import core.*;

public class Listen extends Verb {

    public Listen() {
        super("listen",
                new String[]{"hear", "pay attention", "listen to"},
                Verb.usage().bare().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        final Player player = construct.getPlayer();
        construct.getWorld();
        final Area area = player.getCurrentArea();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.getSound() != null) {
                    System.out.println(noun.getSound());
                } else {
                    System.out.println("It sounds like every other "
                            + noun.getName() + " you've ever heard");
                }
            } else if (area.getSound() != null) {
                System.out.println(area.getSound());
            } else {
                System.out.println("It doesn't sound like anything");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
