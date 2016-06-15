package items;
import core.*;
import verbs.Use;

public class BrokenComputers extends Item {

    public BrokenComputers() {
        super();
        this.name("Broken Computers")
                .look("There are a couple dozen computers here. They look like "
                        + "they haven't been used in a long time.")
                .examine("Most of the computer screens are smashed in. A thick "
                        + "layer of dust covers all of the components.")
                .synonym("broken computers", "computers", "computer")
                .smell("They smell like they're broken.")
                .taste("They taste like they're broken.");
    }

    @Override
    public boolean interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final Player player = context.getPlayer();
        if (verb.getClass().equals(Use.class)) {
            System.out.println("You try to turn on one of the computers, "
                    + "but nothing happens.");
            player.addScore(10);
            return true;
        }
        return false;
    }
}
