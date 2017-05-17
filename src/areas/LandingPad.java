package areas;

import core.*;
import items.*;

public class LandingPad extends Area<NoState> {
    public LandingPad(final World containingWorld) {
        super(containingWorld);
        this.portals().east(new Portal(false, CrampedHall.class)).up(new Portal(true, Roof.class));
        this.title("Area outside Band Room")
                .description("This is a small space just outside the band"
                        + " room, with a zipline extending upward.")
                .dark(false)
                .taste("You are outside, do you enjoy eating dirt?")
                .sound("You hear wind in the trees nearby.").smell("You smell fresh air.");
    }
}
