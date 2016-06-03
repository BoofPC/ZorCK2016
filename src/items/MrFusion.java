package items;

import core.*;

public class MrFusion extends Item {

    public MrFusion(){
        super();
        //not drinkable because you need it for the time machine
        this.name("Mr.Fusion")
            .description("This is one of the parts of the time"
                + " machine!")
            .synonym("mr fusion")
            .synonym("mr. fusion");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
