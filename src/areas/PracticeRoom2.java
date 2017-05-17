package areas;

import core.*;
import items.*;

/**
 * Room: PracticeRoom2<br>
 * North: CrampedHall1<br>
 * East: wall<br>
 * West: wall<br>
 * South: wall<br>
 * Initial Description: A cupboard stands in the corner, and the place looks ransacked. A door leads
 * to the north.<br>
 * Description: This is the second practice room<br>
 * Dark?: True<br>
 * Smell: You smell old sweat.<br>
 * Sound: You hear echos of your breathing<br>
 * Taste: Why would you want to lick the room? People dumped their spit valves out on the floor!<br>
 * Special States: n/a<br>
 */
public class PracticeRoom2 extends Area<NoState> {

    public PracticeRoom2(final World containingWorld) {
        super(containingWorld);
        this.title("Second Practice Room")
                .description("This is the second practice room, with a doorway "
                        + "leading north. A cupboard stands against the east wall, but"
                        + " the place looks ransacked.")
                .shortDescription("This is the second practice room.")
                .dark(true)
                .taste("Why would you want to lick the room?"
                        + " People dumped their spit valves out on the floor!")
                .sound("You hear the echos of your breathing.").smell("You smell old sweat.");
    }
}
