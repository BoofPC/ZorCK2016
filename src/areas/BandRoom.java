package areas;

import core.*;
import items.*;

public class BandRoom extends Area {

    public BandRoom(World containingWorld) {
        super(containingWorld);
        this.portals().south(new Portal(false, CrampedHall.class));
        this.title("Band Room")
                .description("This is an incredibly large room, but a"
                        + " boiler that appears to have fallen through the celing"
                        + " takes up most of it. Behind it are multiple strange instruments."
                        + " One vaugely reminds you of a piano.")
                .shortDescription("This is the band room.")
                .item(new Vibraphone()).dark(true);
    }

    @Override
    public void interact(final Command command, final Context context) {
        final String verb = command.getVerb().getTitle();
        final String noun = command.getNoun().name();

        if ((verb.equals("taste") || verb.equals("lick")) && noun.equals("room")) {
            System.out.println("Why would you want to lick the room?"
                    + " People dumped their spit valves out on the floor!");
        } else if (verb.equals("listen")) {
            System.out
                    .println("You faintly hear echos of crying children and poorly played music.");
        } else if (verb.equals("smell")) {
            System.out.println("You smell sweat and pain.");
        } else {
            super.interact(command, context);
        }
    }
}
