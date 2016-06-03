package items;

import core.*;

public class DarkChocolate extends Item{

    public DarkChocolate(){
        super();
        this.setUsageKey(Item.TAKE,1);
        this.setUsageKey(Item.EAT,2);
        this.setName("Dark Chocolate");
        this.setDescription("Its looks dark and tasty");
        this.addSynonym("dark chocolate");
        this.addSynonym("chocolate");
        this.addSynonym("chocolate bar");
        this.setTaste("It tastes like heaven");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
