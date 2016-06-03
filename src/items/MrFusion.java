package items;

import core.*;

public class MrFusion extends Item {

    public MrFusion(){
        super();
        //not drinkable because you need it for the time machine
        this.name("Mr.Fusion");
        this.description("This is one of the parts of the time"
                + " machine!");
        this.synonym("mr fusion");
        this.synonym("mr. fusion");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
