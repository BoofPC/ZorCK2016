package verbs;

import java.util.Arrays;

import core.*;

public class Smell extends Verb {

    public Smell() {
        super("smell",
                Arrays.asList("sniff"),
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
            if (!noun.name().equals("noItem")) {
                if (noun.smell() != null) {
                    System.out.println(noun.smell());
                } else {
                    System.out.println("It smells like every other "
                            + noun.name() + " you've ever smelled");
                }
            } else if (area.getSmell() != null) {
                System.out.println(area.getSmell());
            } else {
                System.out.println("It doesn't smell like anything");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
