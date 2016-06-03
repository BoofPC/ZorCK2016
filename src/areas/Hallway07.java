package areas;

import core.*;
import items.*;

public class Hallway07 extends Area {

    public Hallway07(final World containingWorld) {
        super(containingWorld);

        this.getPortals().north(new Portal(Portal.State.UNLOCKED, "WomensRestroom"))
            .west(new Portal(Portal.State.UNLOCKED, "Hallway08"));

        this.setTitle("Hallway");
        this.setInitialDescription("This is the end of the hallway. To the north is "
                + "a doorway that leads to the women's restroom. Off to the "
                + "side is a staircase that has been barricaded with chairs. "
                + "The hallway continues to the west. A stale cracker lies in "
                + "the center of the hallway.");
        this.setDescription("This is the end of the hallway.");

        this.addItem(new Cracker());
    }

    @Override
    public void interact(final Command command, final Context context){
        Item noun;
        noun = command.getNoun();
        //if you don't have any special interactions, just put this:
        if(command.getNoun() !=  null) {
            noun.interact(command,context);
        }
        if(!context.getSkipGeneral()) {
            command.getVerb().run(command, context);
        }
    }
}