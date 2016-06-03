package items;

import core.*;

public class WhiteChocolate extends Item{

    public WhiteChocolate(){
        super();
        this.usage().take(Usage.Take.TAKABLE).food(Usage.Food.EDIBLE);
        this.name("White Chocolate");
        this.description("Its looks light and disgusting");
        this.synonym("white chocolate");
        this.synonym("chocolate");
        this.synonym("chocolate bar");
        this.taste("It tastes like hell");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
