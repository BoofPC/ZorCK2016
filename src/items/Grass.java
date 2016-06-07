package items;

import core.*;

public class Grass extends Item {
    public Grass() {
        super();
        this.usage().take(Item.TOO_HEAVY).recieve(Item.RECIEVE);
        this.name("Grass").description("Some grass in a small planter..").synonym("gras", "grass")
                .smell("MM.. smells great");
        this.key(new Scissors().name());


    }
}

