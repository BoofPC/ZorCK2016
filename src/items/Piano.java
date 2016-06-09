package items;

import core.*;

public class Piano extends Item {
    public Piano() {
        super();
        this.usage().take(Item.TOO_HEAVY);

        this.name("Piano")
            .synonym("piano", "keyboard")
            .examine("A very sad piano. It looks like its waiting for its Mozart");
    }
}
