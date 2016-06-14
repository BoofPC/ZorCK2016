package areas;

import core.*;
import items.*;

public class ChemicalStorageRoom extends Area {

    public ChemicalStorageRoom(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, BirkenfeldsRoom.class));
        this.title("Chemical Storage Room").description("You're in the Chemical Storage room. This room smells weird. You feel light headed.").shortDescription("You're in the Chemical Storage room. You feel light headed.").articleThe(true)
                .item(new Door(false, "Southern Door", null, this.portals().south()))
                .item(new Chemical())
                .item(new Vape());
    }
    @Override
    public void interact(final Command command, final Context context) {
        if (command.getVerb().getTitle().equals("take") && (command.getNoun().hasMatching("vape"))) {
            System.out.println("You got the vape");
            System.out.println("Now, you can rip the fattest clouds!!!!!!");
        }
        if (command.getVerb().getTitle().equals("take") && (command.getNoun().hasMatching("chemical"))) {
            System.out.println("You got the chemical");
            System.out.println("Now, go give it to Mr.Birkenfeld");
        }
        super.interact(command, context);
    }
}