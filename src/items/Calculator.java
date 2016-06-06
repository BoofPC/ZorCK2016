package items;

import core.*;

/**
 * This is a special item needed to complete the game.
 */
public class Calculator extends Item {

    public Calculator() {
        super();
        this.usage().take(Item.TAKABLE).active(Item.OFF);
        //make the calculator do something when it's on
        //oh wait... not in the game anymore
        this.name("Calculator")
            .synonym("calculator", "graphing calculator")
            .description("It's a TI-84 Plus Supreme Deluxe Color Limited Edition "
                + "Graphing Calculator with a 4K touchscreen!");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
