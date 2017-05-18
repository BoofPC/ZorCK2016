package areas;

import core.*;
import items.*;

public class BirkenfeldsRoom extends Area<NoState> {

    public BirkenfeldsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().southeast(new Portal(false, Hallway01.class));
        this.title("Birkenfeld's Room")
                .description(
                        "This is Mr.Birkenfelds room. As you walk into the classroom you hear Mr.Birkenfeld yelling at his students to do their packets. Your ears starts to hurt. This room is very messy. You see the door to the Chemical Storage Room to the north.")
                .shortDescription(
                        "This is Mr.Birkenfelds room. The room is very messy and your ears hurt. You see the door to the Chemical Storage Room to the north.")
                .item(new Door(false, "Southeastern Door", null, this.portals().southeast()))
                .item(new MrBirkenfeld());

    }

    @Override
    public void interact(final Command command, final Context context) {
        super.interact(command, context);
    }

}
