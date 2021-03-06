package items;

import core.*;

public class Blackmail extends Item {

    public Blackmail() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("blackmail")
                .examine("It's a note from an unknown author...")
                .synonym("mail");
    }
}
