package areas;

import core.*;
import items.*;

public class PracticeRoom1 extends Area<NoState> {
    public PracticeRoom1(final World containingWorld) {
        super(containingWorld);
        this.portals().north(new Portal(false, CrampedHall.class));
        this.title("First Practice Room")
                .description("This is the first practice room, with a doorway "
                        + "leading north. Tattered carpet hangs from the walls, and"
                        + " a piano stands languishing in the corner.")
                .shortDescription("This is the first practice room.").dark(true)
                .taste("Why would you want to lick the room?"
                        + " People dumped their spit valves out on the floor!")
                .sound("You faintly hear the sound of a forlorn"
                        + " oboe trying to succeed in life.")
                .smell("You smell broken dreams floating through the air.");
    }
}
