package items;

import core.*;

public class MrFusion extends Item {

    public MrFusion(){
        super();
        //not drinkable because you need it for the time machine
        this.setName("Mr.Fusion");
        this.setDescription("This is one of the parts of the time"
                + " machine!");
        this.addSynonym("mr fusion");
        this.addSynonym("mr. fusion");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
