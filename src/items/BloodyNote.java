package items;

import core.*;

//Item found in Comp. Sci. Room
public class BloodyNote extends Item {

    public BloodyNote() {
        super();
        this.usage().take(Item.TAKABLE).read(Item.READABLE);
        this.name("Bloody Note")
            .look("There's a note on a desk, lying on the edge of a pool of blood.")
            .examine("It's a note written in blood.")
            .synonym("bloody note", "note", "note written in blood")
            .read("Why wouldn't he just grade our assignments??!?");
    }
}
