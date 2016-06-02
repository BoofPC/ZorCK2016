package verbs;

import core.*;

public class Listen extends Verb {

    public Listen() {
        super("listen",
                new String[]{"hear", "pay attention", "listen to"},
                new boolean[]{true, true, false});
    }

    public void run(Command command, Context construct) {
        int direction = command.getDirection();
        Item noun = command.getNoun();

        Player player = construct.getPlayer();
        World world = construct.getWorld();
        Area area = player.getCurrentArea();

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
