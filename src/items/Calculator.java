package items;

import core.*;

/**
 * This is a special item needed to complete the game.
 */
public class Calculator extends Item {

    public Calculator() {
        super();
        this.setUsageKey(Item.TAKE, 1);
        //turned off by default
        this.setUsageKey(Item.TURN_ON, 2);
        //TODO: make the calculator do something when it's on

        this.setName("Calculator");
        this.addSynonym("calculator");
        this.addSynonym("graphing calculator");
        this.setDescription("It's a TI-84 Plus Supreme Deluxe Color Limited Edition "
                + "Graphing Calculator with a 4K touchscreen!");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
