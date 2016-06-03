package items;

import core.*;

public class DarkChocolate extends Item{

    public DarkChocolate(){
        super();
        this.usage().take(Usage.Take.TAKABLE).food(Usage.Food.EDIBLE);
        this.name("Dark Chocolate");
        this.description("Its looks dark and tasty");
        this.synonym("dark chocolate");
        this.synonym("chocolate");
        this.synonym("chocolate bar");
        this.taste("It tastes like heaven");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
