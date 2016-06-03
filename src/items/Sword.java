package items;

import core.*;

public class Sword extends Item{

    public Sword(){
        super();
        this.setUsageKey(Item.TAKE,1);
        this.setName("Elvish Sword");
        this.addSynonym("elvish sword");
        this.addSynonym("sword");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
