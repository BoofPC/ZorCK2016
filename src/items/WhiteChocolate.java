package items;

import core.*;

public class WhiteChocolate extends Item{

    public WhiteChocolate(){
        super();
        this.usage().take(Item.TAKABLE).food(Item.EDIBLE);
        this.name("White Chocolate")
            .description("Its looks light and disgusting")
            .synonym("white chocolate")
            .synonym("chocolate")
            .synonym("chocolate bar")
            .taste("It tastes like hell");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
