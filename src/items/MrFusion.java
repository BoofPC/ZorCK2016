package items;

import core.*;

public class MrFusion extends Item {

    public MrFusion(){
        super();
        //not drinkable because you need it for the time machine
        this.name("Mr.Fusion")
            .examine("This is one of the parts of the time machine!")
            .synonym("mr fusion", "mr. fusion");
    }
}
