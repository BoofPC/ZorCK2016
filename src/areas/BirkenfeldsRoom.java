package areas;

import core.*;
import items.*;

public class BirkenfeldsRoom extends Area<NoState> {

    public BirkenfeldsRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().southeast(new Portal(false, Hallway01.class))
                .north(new Portal(true, ChemicalStorageRoom.class));
        this.title("Birkenfeld's Room")
                .description(
                        "This is Mr.Birkenfelds room. This room is very messy. "
                                + "You see the door to the Chemical Storage Room "
                                + "to the north.")
                .shortDescription(
                        "This is Mr.Birkenfelds room. The room is very messy and your ears hurt. You see the door to the Chemical Storage Room to the north.")
                .item(new Door(false, "Southeastern Door", null, this.portals().southeast()))
                .item(new Door(true, "Northern Door", null, this.portals().north()))
                .item(new MrBirkenfeld());

    }

    @Override
    public void interact(final Command command, final Context context) {
        if (command.getVerb().getTitle().equals("talk")
                && (command.getNoun().name().equals("mr.birkenfeld"))) {
            this.portals().north().unlock();
            this.item(new Door(false, "Northern Door", null, this.portals().north()));
        }

        super.interact(command, context);
    }

}
