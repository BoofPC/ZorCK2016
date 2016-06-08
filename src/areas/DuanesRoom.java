package areas;

import core.*;
import items.*;

public class DuanesRoom extends Area {

    public DuanesRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().north(new Portal(false, Hallway08.class));
        this.title("Duane's Room").description("The room you have entered contians "
                + "many wothless items, and feels sad in a spunky fresh sort of "
                + "way. However, it has a few notable items, notably a cat and a"
                + " tall shelf with snacks at the top").shortDescription("There "
                + "are snacks on top of a tall shelf and a fuzzy orange cat.")
                .item(new Door(false, "Northern Door", null, this.portals().north()));
    }
        

    @Override
    public void interact(final Command command, final Context context) {
        if(command.getVerb().hasMatching("Use") && command.getNoun().hasMatching("Laser Pointer")){
            System.out.println("The cat jumps up on the self and knocks over "
                    + "some treats. You eat them.");
            context.getPlayer().addHp(10);
        }
    }
}
