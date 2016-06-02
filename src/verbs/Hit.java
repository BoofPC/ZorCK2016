package verbs;

import core.*;

public class Hit extends Verb {

    public Hit() {
        super("hit",
                new String[]{"punch", "kick", "headbutt"},
                new boolean[]{false, true, false});
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        Item noun = command.getNoun();

        Player player = construct.getPlayer();
        construct.getWorld();
        Area area = player.getCurrentArea();

        if (noun != null) {
            if (!noun.getName().equals("noItem")) {
                if (noun.getUsageKey(11) == 2) {
                    noun.drop(area);
                    System.out.println("You hit the " + noun.getName());
                    if (noun.getInside() != null) {
                        System.out.println("It dropped the "
                                + noun.getInside().getName());
                    }
                    noun.drop(area);
                    area.removeItem(noun);
                } else {
                    System.out.println("Now why would you do that?");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
