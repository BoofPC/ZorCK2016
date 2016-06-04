package items;

import core.*;

public class Cracker extends Item {

    public Cracker() {
        super();
        this.usage().take(Item.TAKABLE).food(Item.EDIBLE);
        //can't break it. it's an indestructable cracker!

        this.name("Cracker")
            .synonym("cracker")
            .description("It's a stale cracker.")
            .taste("It tastes slightly salty, with a hint of carpet.");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
