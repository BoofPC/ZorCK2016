package items;

import core.*;

/* This item is found in the center area. It's special,
*  because a player can die while running with scissors.
*  */
public class Scissors extends Item {

    public Scissors() {
        super();
        this.usage().take(Item.TAKABLE).read(Item.READABLE);
        this.name("The Scissors")
                /* This is printed out every time the player looks in the room. */
                .look("A pair of extraordinarily sharp scissors lie here, as if they're waiting for something.")
                /* This is read when the player examines the scissors. */
                .examine("A pair of extraordinarily sharp scissors."
                        + " Just looking at them sends a chill down your spine.")
                /* These are names by which the item can be referred to.  */
                .synonym("the scissors", "scissors", "scisors", "scissor")
                /* This is read when the player reads the item. */
                .read("You don't want to get your eyes that close to see if anything's there.")
                /* This is read when the player listens to the item. */
                .sound("You move them and it sounds like the very molecules of the air are being split.")
                /* This is read when the player smells the item. */
                .smell("They smell of blood and cold steel.");
    }
}
