package areas;

import core.*;
import items.*;
import java.util.Random;

public class FishersRoom extends Area<NoState> {

    public FishersRoom(final World containingWorld) {
        super(containingWorld);
        this.portals().south(new Portal(Portal.State.UNLOCKED, Hallway17.class));
        this.title("Ms. Fisher's Room")
                .description("You are in Fisher's room as various papers on "
                + "the downfall of the Ming Empire and essays as well as Silk "
                + "Roads trading changed China while a Reggae-sounding song "
                + "blares through the speakers. There is a lantern on the floor.")
                .shortDescription("This is Fisher's room, it smells vaguely of perspiration "
                        + "and the Spanish Inquisition.")
                .dark(false).smell("It smells like teen spirit (or in other words perspiration)")
                .taste("You taste good ol' oxygen")
                .sound("Blaring reggae music pounds through your ear drums")
                .item(new Door(false, "Southern Door", null, this.portals().south()))
                .item(new Lantern());
    }

    @Override
    public void interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        if (verb.getTitle().equals("look")) {
            //This is unnecessary - It should be the description
            final Random rand = new Random();
            final int num = rand.nextInt(9);
            if (num < 1) {
                System.out.println("You see scattered papers around the room, some"
                        + " saying 'You can get it if you really want' and others"
                        + " discussing the extent to which the Kyoto Protocol assisted"
                        + " United States' environmental impacts."
                        + " Nothing seems to be of interest in this room.");
            } else {
                System.out.println(this.description());
            }
        } else {
            final Item noun = command.getNoun();
            if (verb.getTitle().equals("take") && (noun.equals("paper") || noun.equals("papers"))) {
                System.out.println(
                        "You feel a burning sensation as your legs and arms feel as if they"
                                + " are on fire. A faint voice in the distance yells 'Plagarism!'. You immediately"
                                + " drop the papers due to fright.");
            }

            else if ((verb.getTitle().equals("hello"))) {
                System.out.println("Fisher says, 'Bring me some coffee.'");
            }

            //This is unnecessary
            else if (verb.getTitle().equals("take") && noun.equals("lantern")) {
                if (this.hasMatching(new Lantern())) {
                    System.out.println("You picked up the lantern!");
                    //Add addition to Inventory later
                    this.removeItem(new Lantern());
                } else {
                    System.out.println("There is no lantern in here...");
                }
            }

            else {
                super.interact(command, context);
            }
        }
    }


}
