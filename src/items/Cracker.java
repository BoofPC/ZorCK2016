package items;

import core.*;

public class Cracker extends Item {

    public Cracker() {
        super();
        this.setUsageKey(Item.TAKE, 1);
        this.setUsageKey(Item.EAT, 2);
        //can't break it. it's an indestructable cracker!

        this.setName("Cracker");
        this.addSynonym("cracker");

        this.setDescription("It's a stale cracker.");

        this.setTaste("It tastes slightly salty, with a hint of carpet.");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
