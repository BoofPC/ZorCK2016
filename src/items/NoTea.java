package items;

import core.*;

public class NoTea extends Item{

    public NoTea(){
        super();
        this.name("No Tea")
            .examine("What? That makes no sense. Pull yourself together!")
            .synonym("no tea");
    }
}
