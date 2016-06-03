package items;

import core.*;

public class DarkChocolate extends Item{

    public DarkChocolate(){
        super();
        this.usage().take(Item.TAKABLE).food(Item.EDIBLE);
        this.name("Dark Chocolate")
            .description("Its looks dark and tasty")
            .synonym("dark chocolate")
            .synonym("chocolate")
            .synonym("chocolate bar")
            .taste("It tastes like heaven");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
