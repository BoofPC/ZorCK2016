package items;

import core.*;

public class Cracker extends Item {

    public Cracker() {
        super();
        this.usage().take(Usage.Take.TAKABLE).food(Usage.Food.EDIBLE);
        //can't break it. it's an indestructable cracker!

        this.name("Cracker");
        this.synonym("cracker");

        this.description("It's a stale cracker.");

        this.taste("It tastes slightly salty, with a hint of carpet.");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
