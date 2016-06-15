package areas;

import core.*;
import items.*;
import verbs.*;

/**
 * This area contains toolbox. If you walk anywhere but west, you fall off of the roof and die.
 */
public class Roof extends Area<NoState> {

    private int countdown = -1;

    public Roof(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(Portal.State.UNLOCKED, ConcreteGround.class))
                .west(new Portal(Portal.State.UNLOCKED, WomensRestroom.class))
                .down(new Portal(Portal.State.UNLOCKED, BandRoom.class));

        this.title("Roof").articleThe(true)
                .description("The roof is largely empty. Only a small red "
                        + "toolbox lies on the ground. To the south is the edge of "
                        + "the roof. To the west is a window leading to the Women's Restroom.")
                .sound("You can hear the toolbox.").smell("It smells like a red toolbox.")
                .item(new Toolbox()).item(new ZiplineDown());
    }

    @Override
    public void interact(final Command command, final Context context) {
        final Player player = context.getPlayer();
        final World.Direction direction = command.getDirection();
        final Item noun = command.getNoun();
        final Verb verb = command.getVerb();
        final Class<? extends Verb> verbClass = verb.getClass();
        final Class<? extends Item> nounClass = noun != null ? noun.getClass() : null;

        switch (this.countdown) {
            case 1:
                System.out.println("You hear the window unlock.");
                this.countdown--;
                break;
            case 0:
                System.out.println("Maybe you shouldn't throw unconscious teachers off roofs."
                        + "\nYou hear the window slide open.");
                player.setDeath(Game.Status.DIE);
                this.countdown--;
                return;
            case -1:
                break;
            default:
                this.countdown--;
                break;
        }

        if (verbClass.equals(Move.class) && direction == World.Direction.SOUTH) {
            System.out.println("Whoops. You walked off of the roof.");
            super.interact(command, context);
        } else if (verbClass.equals(Take.class) && nounClass.equals(Toolbox.class)) {
            this.sound("Sounds like there's no toolbox here.")
                    .smell("It smells like there's no toolbox here.");
            command.getVerb().run(command, context);
        } else if (verbClass.equals(Throw.class) && nounClass.equals(MrBooth.class)) {
            System.out.println("You toss Mr. Booth off the edge of the roof. You monster.");
            final MrBooth booth = (MrBooth) noun;
            player.removeItem(booth);
            context.getWorld().getArea(ConcreteGround.class).item(booth);
            booth.changeState(MrBooth.State.FALLEN);
            this.portals().west().lock();
            this.countdown = 7;
        } else {
            super.interact(command, context);
        }
    }
}
