package areas;

import core.*;

public class CrampedHall extends Area<NoState> {
    public CrampedHall(final World containingWorld) {
        super(containingWorld);
        this.portals().south(new Portal(false, PracticeRoom1.class));
        this.portals().east(new Portal(false, PracticeRoom2.class));
        this.portals().west(new Portal(false, LandingPad.class));
        this.portals().north(new Portal(false, BandRoom.class));
        this.title("Cramped Hallway")
                .description("This is a very cramped hallway, with a"
                        + " doorway at each of the four cardinal directions."
                        + " This place seems as though it was once full of hope.")
                .shortDescription("This is the cramped hallway.").dark(true)
                .taste("Why would you want to lick the room?"
                        + " People dumped their spit valves out on the floor!")
                .sound("You hear echos of chromatic scales being played very terribly.")
                .smell("You smell rotting school lunches.");
    }
}
