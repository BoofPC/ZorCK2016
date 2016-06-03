package items;

import core.*;

public class WhiteChocolate extends Item{

    public WhiteChocolate(){
        super();
        this.usage().take(Usage.Take.TAKABLE).food(Usage.Food.EDIBLE);
        this.setName("White Chocolate");
        this.setDescription("Its looks light and disgusting");
        this.addSynonym("white chocolate");
        this.addSynonym("chocolate");
        this.addSynonym("chocolate bar");
        this.setTaste("It tastes like hell");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
