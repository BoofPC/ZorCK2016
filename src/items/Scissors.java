package items;

import core.*;

public class Scissors extends Item {

    public Scissors() {
        super();
        this.usage().take(TAKABLE).read(READABLE);
        this.name("The Scissors")
                .description(
                        "A pair of extraordinarily sharp scissors. Just looking at them sends a chill down your spine.")
                .synonym("the scissors", "scissors", "scisors", "scissor")
                .text("You don't want to get your eyes that close to see if anything's there.")
                .sound("You move them and it sounds like the very molecules of the air are being split.")
                .smell("They smell of blood and cold steel.");

    }
}
